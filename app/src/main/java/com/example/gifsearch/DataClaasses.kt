package com.example.gifsearch

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data")
    val res: List<DataObject>,
)

data class DataObject(
    @SerializedName("id")
    val id_: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("images")
    val data1: DataImage
)

data class DataImage(
    @SerializedName("original")
    val images: ImageGif
)

data class ImageGif(
    @SerializedName("url")
    val urlImage: String
)