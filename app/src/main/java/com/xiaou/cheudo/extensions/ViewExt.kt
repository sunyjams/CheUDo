package com.xiaou.cheudo.extensions

import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup

/**
 * @copyright:
 * author:James
 * date:2019/4/29
 * description
 */
fun ViewGroup.backgroundColor(@ColorRes color:Int){
    this.setBackgroundColor(ContextCompat.getColor(context, color))
}

fun View.backgroundColor(@ColorRes color:Int){
    this.setBackgroundColor(resources.getColor(color))
}

fun View.gone(){
    if(this.visibility != View.GONE){
        this.visibility = View.GONE
    }
}

fun View.invisible(){
    if(this.visibility != View.INVISIBLE){
        this.visibility = View.INVISIBLE
    }
}

fun View.visible(){
    if(this.visibility != View.VISIBLE){
        this.visibility = View.VISIBLE
    }
}


