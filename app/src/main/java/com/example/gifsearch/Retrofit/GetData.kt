package com.example.gifsearch.Retrofit

import com.example.gifsearch.DataResult
import retrofit2.http.GET
import retrofit2.http.Query

interface GetData {

    @GET("gifs/search")
    fun getGifs(
        @Query("api_key") api_key: String,
        @Query("q") name: String?
    ): retrofit2.Call<DataResult>

}