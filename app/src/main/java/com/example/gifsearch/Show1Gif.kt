package com.example.gifsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Show1Gif : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show1_gif)

        val imageView = findViewById<ImageView>(R.id.imageViewShow)
        val imageTitle = findViewById<TextView>(R.id.imgTitle)
        val imageId = findViewById<TextView>(R.id.imgId)

        val a = intent.getStringExtra("data")
        val data = a?.split(' ')

        val imageUrl = data?.get(0)
        val imgeId = data?.get(1)
        val imgeTitle = data?.get(2)

        Glide.with(this)
            .load(imageUrl)
            .into(imageView)

        imageTitle.text = imgeTitle
        imageId.text = imgeId
    }
}