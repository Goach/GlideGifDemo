package com.goach.glidegifdemo

import android.support.rastermill.FrameSequenceDrawable
import com.bumptech.glide.load.resource.drawable.DrawableResource

/**
 * Goach All Rights Reserved
 *User: Goach
 *Email: goach0728@gmail.com
 *Des:
 */
class GifResource(fsd: FrameSequenceDrawable):DrawableResource<FrameSequenceDrawable>(fsd) {
    override fun getResourceClass(): Class<FrameSequenceDrawable> {
        return FrameSequenceDrawable::class.java
    }

    override fun getSize(): Int {
        return 0
    }

    override fun recycle() {
        drawable.stop()
        drawable.destroy()
    }
}