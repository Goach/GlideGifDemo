package com.goach.glidegifdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* val frameSequence = FrameSequence.decodeStream(this.assets.open("lagou_my.gif"))
        val frameSequenceDrawable = FrameSequenceDrawable(frameSequence)
        iv.setImageDrawable(frameSequenceDrawable)*/
        GlideApp.with(this)
                .asGif2()
                .load("http://storage.slide.news.sina.com.cn/slidenews/77_ori/2018_28/74766_829059_301414.gif")
                .into(iv)
    }
}
