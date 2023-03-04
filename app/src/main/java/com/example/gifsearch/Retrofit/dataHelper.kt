package com.example.gifsearch.Retrofit

import com.google.gson.annotations.SerializedName

data class dataHelper (
    @SerializedName("status") val status: String,
    @SerializedName("listGifs") val listGifs: List<DataGifs>
    )