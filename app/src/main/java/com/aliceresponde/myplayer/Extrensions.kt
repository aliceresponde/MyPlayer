package com.aliceresponde.myplayer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

fun Context.toast(message: String, long: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, long).show()
}

// crear funcion de extension toast para ViewHolder   que use el toast de context
fun RecyclerView.ViewHolder.toast(message: String) {
    itemView.context.toast(message)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadURL(urlPath: String){
    Picasso.with(context).load(urlPath).into(this)
}

inline fun <reified T: Activity> Context.startActivity (){
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T: View> View.find(@IdRes idRes: Int): T{
   return findViewById<T>(idRes)
}
inline fun <reified T: View> RecyclerView.ViewHolder.find(@IdRes idRes: Int): T{
   return itemView.find(idRes)
}