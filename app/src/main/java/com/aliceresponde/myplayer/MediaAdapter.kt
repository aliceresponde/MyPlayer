package com.aliceresponde.myplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MediaAdapter(val items: List<MediaItem>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int  = items.size

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val media_item_pic = v.findViewById<ImageView>(R.id.media_item_pic) as ImageView
        val media_item_tile = v.findViewById<TextView>(R.id.media_item_title) as TextView

        fun bind(item: MediaItem) {
            media_item_tile.text = item.title
          Picasso.with(media_item_pic.context).load(item.iconUrl).into(media_item_pic)
        }
    }
}