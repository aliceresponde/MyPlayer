package com.aliceresponde.myplayer

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_media_item.view.*

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
        //        val mediaItemPic = view.findViewById(R.id.media_item_pic) as ImageView
        //        val mediaItemPic = view.find<ImageView>(R.id.media_item_pic)

        fun bind(item: MediaItem) {
            itemView.media_item_title.text = item.title
            itemView.media_item_pic.loadURL(item.iconUrl)
            itemView.media_video_indicator.visibility = when (item.type) {
                MediaItem.Type.PHOTO -> View.GONE
                MediaItem.Type.VIDEO -> View.VISIBLE
            }
        }
    }
}