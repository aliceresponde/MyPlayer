package com.aliceresponde.myplayer

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MediaAdapter(val items: List<MediaItem>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        var v = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        var v = parent.inflate(R.layout.view_media_item)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val mediaItemTile = view.findViewById(R.id.media_item_title) as TextView
        val mediaItemTile = view.find<TextView>(R.id.media_item_title)
        //        val mediaItemPic = view.findViewById(R.id.media_item_pic) as ImageView
        val mediaItemPic = view.find<ImageView>(R.id.media_item_pic)
        fun bind(item: MediaItem) {
            mediaItemTile.text = item.title
//            Picasso.with(mediaItemPic.context).load(item.iconUrl).into(mediaItemPic)
            mediaItemPic.loadURL(item.iconUrl)
            toast("hello")
        }
    }
}