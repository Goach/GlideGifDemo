package com.goach.glidegifdemo

import android.content.Context
import android.support.rastermill.FrameSequenceDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import java.io.InputStream

/**
 * Goach All Rights Reserved
 *User: Goach
 *Email: goach0728@gmail.com
 *Des:
 */
@GlideModule
class GifGlideModel:AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.append(Registry.BUCKET_GIF,
                InputStream::class.java,
                FrameSequenceDrawable::class.java,
                GifDecoder(glide.bitmapPool))

    }
}