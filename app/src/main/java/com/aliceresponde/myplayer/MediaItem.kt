package com.aliceresponde.myplayer

data class MediaItem (val title: String , val iconUrl: String,
                      val type : Type){
    enum class Type {PHOTO, VIDEO}
}