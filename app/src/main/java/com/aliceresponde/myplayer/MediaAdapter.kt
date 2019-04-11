package com.aliceresponde.myplayer

import android.opengl.Visibility
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
        //        val mediaItemPic = view.findViewById(R.id.media_item_pic) as ImageView
        val mediaItemTile = view.find<TextView>(R.id.media_item_title)
        val mediaItemPic = view.find<ImageView>(R.id.media_item_pic)
        val mediaVideoIndicator = view.find<ImageView>(R.id.media_video_indicator)
        fun bind(item: MediaItem) {

            mediaVideoIndicator.visibility = when (item.type) {
                MediaItem.Type.PHOTO -> View.GONE
                MediaItem.Type.VIDEO -> View.VISIBLE
            }

            mediaItemTile.text = item.title
//            Picasso.with(mediaItemPic.context).load(item.iconUrl).into(mediaItemPic)
            mediaItemPic.loadURL(item.iconUrl)
            toast("hello")
        }
    }
}