package com.example.gifsearch

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GifsAdapter(val context: Context, val gifs: List<DataObject>) : RecyclerView.Adapter<GifsAdapter.GifViewHolder>() {

    lateinit var _Listener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        _Listener = listener
    }

    class GifViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imageView_ = itemView.findViewById<ImageView>(R.id.gif)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.card_gif, parent, false)
        return GifViewHolder(v, _Listener)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val data = gifs[position]
        Glide.with(context)
            .load(data.data1.images.urlImage)
            .into(holder.imageView_)
    }

    override fun getItemCount(): Int {
        return gifs.size
    }

}
