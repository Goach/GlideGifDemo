package com.goach.glidegifdemo;

import android.support.rastermill.FrameSequenceDrawable;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.request.RequestOptions;
import static com.bumptech.glide.request.RequestOptions.decodeTypeOf;

/**
 * Goach All Rights Reserved
 * User: Goach
 * Email: goach0728@gmail.com
 * Des:
 */
@GlideExtension
public class GifExtension {
    private static final RequestOptions DECODE_TYPE_GIF = decodeTypeOf(FrameSequenceDrawable.class);
    private GifExtension(){
    }
    @GlideType(FrameSequenceDrawable.class)
    public static void asGif2(RequestBuilder<FrameSequenceDrawable> requestBuilder){
        requestBuilder.apply(DECODE_TYPE_GIF);
    }

}
