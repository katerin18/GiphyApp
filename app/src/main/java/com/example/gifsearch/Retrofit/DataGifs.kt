package com.example.gifsearch.Retrofit

import com.google.gson.annotations.SerializedName

data class DataGifs (
    @SerializedName("id") val idGif: String,
    @SerializedName("title") val titleGif: String,
    @SerializedName("urlToGif") val urlToGif: String
    )