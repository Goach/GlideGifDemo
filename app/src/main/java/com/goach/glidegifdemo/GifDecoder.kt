package com.goach.glidegifdemo

import android.graphics.Bitmap
import android.support.rastermill.FrameSequence
import android.support.rastermill.FrameSequenceDrawable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import java.io.InputStream
import java.nio.ByteBuffer

/**
 * Goach All Rights Reserved
 *User: Goach
 *Email: goach0728@gmail.com
 *Des:
 */
class GifDecoder<Model>(private val bitmapPool: BitmapPool):ResourceDecoder<Model,FrameSequenceDrawable> {
    override fun handles(source: Model, options: Options): Boolean {
        return true
    }

    override fun decode(source: Model, width: Int, height: Int, options: Options): Resource<FrameSequenceDrawable>? {
        var frameSequence:FrameSequence? = null
        if(source is InputStream){
            frameSequence = FrameSequence.decodeStream(source)
        }else if(source is ByteBuffer){
            frameSequence = FrameSequence.decodeByteBuffer(source)
        }
        if(null != frameSequence){
            val frameSequenceDrawable = FrameSequenceDrawable(frameSequence,
                    object:FrameSequenceDrawable.BitmapProvider{
                        override fun acquireBitmap(minWidth: Int, minHeight: Int): Bitmap {
                            return bitmapPool.getDirty(minWidth,minHeight,Bitmap.Config.ARGB_8888)
                        }

                        override fun releaseBitmap(bitmap: Bitmap?) {
                            bitmapPool.put(bitmap)
                        }
                    })
            return GifResource(frameSequenceDrawable)
        }
        return null
    }
}