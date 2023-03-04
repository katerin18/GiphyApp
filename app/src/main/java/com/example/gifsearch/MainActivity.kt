package com.example.gifsearch

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gifsearch.Retrofit.GetData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.giphy.com/v1/"
const val API_KEY = "X0euSF3iFcmi5Pq6Ygox28JLFFMd8Ah3"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSearch: Button = findViewById(R.id.btnGifSearch)

        val recyclerView = findViewById<RecyclerView>(R.id.gifRecycler)
        val arrGifs = mutableListOf<DataObject>()
        val adapter = GifsAdapter(this, arrGifs)

        btnSearch.setOnClickListener {
            arrGifs.clear()

            val textSearch: EditText = findViewById(R.id.editGifSearch)
            val textSearch_ = textSearch.text.toString()

            recyclerView.adapter = adapter
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(this, 2)

            //setting up setOnItemClickListener
            adapter.setOnItemClickListener(object : GifsAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val intent = Intent(this@MainActivity, Show1Gif::class.java)

                    val imgUrl = arrGifs[position].data1.images.urlImage
                    val imgId = arrGifs[position].id_
                    val imgTitle = arrGifs[position].title

                    intent.putExtra("data", "$imgUrl $imgId $imgTitle") // transfer data to diff activity
                    startActivity(intent)
                }
            })

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            val retrofitService = retrofit.create(GetData::class.java)
            retrofitService.getGifs(API_KEY, textSearch_, 25).enqueue(object : Callback<DataResult?> {
                override fun onResponse(call: Call<DataResult?>, response: Response<DataResult?>) {
                    if (response.body() == null) {
                        Log.d("vvv", "onResponse != OK")
                    }
                    arrGifs.addAll(response.body()!!.res)
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<DataResult?>, t: Throwable) {
                    Log.d("vvv", "onFailure was called!")
                }
            })
        }
    }
}