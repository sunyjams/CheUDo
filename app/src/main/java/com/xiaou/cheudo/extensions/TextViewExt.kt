package com.xiaou.cheudo.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.StyleRes
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.TextView

/**
 * @copyright:
 * author:James
 * date:2019/5/8
 * description
 */
fun TextView.textColor(@ColorRes color:Int){
    this.setTextColor(ContextCompat.getColor(context, color))
}

fun TextView.textAppearance(@StyleRes resId:Int){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        this.setTextAppearance(resId)
    }else{
        this.setTextAppearance(context, resId)
    }
}

fun TextView.leftDrawable(resId:Int){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val leftDrawable = AppCompatResources
                .getDrawable(context, resId)
        leftDrawable?.setBounds(0, 0, right, bottom)
        setCompoundDrawablesWithIntrinsicBounds(leftDrawable, null, null, null)
    } else {
        val leftDrawable = VectorDrawableCompat
                .create(context.resources, resId, null)
        setCompoundDrawablesWithIntrinsicBounds(leftDrawable, null, null, null)
        leftDrawable?.setBounds(0, 0, right, bottom)
    }
}

fun TextView.setHTML(html: String){
    val sequence = Html.fromHtml(html)
    val strBuilder = SpannableStringBuilder(sequence)
    val urls = strBuilder.getSpans(0, sequence.length, URLSpan::class.java)
    for (span in urls) {
        makeLinkClickable(context, strBuilder, span)
    }
    this.text = strBuilder
    this.movementMethod = LinkMovementMethod.getInstance()
}

private fun makeLinkClickable(mContext : Context, strBuilder: SpannableStringBuilder, span: URLSpan) {
    val start = strBuilder.getSpanStart(span)
    val end = strBuilder.getSpanEnd(span)
    val flags = strBuilder.getSpanFlags(span)
    val clickable = object : ClickableSpan() {
        override fun onClick(widget: View) {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(span.url)
            mContext.startActivity(i)
        }
    }
    strBuilder.setSpan(clickable, start, end, flags)
    strBuilder.removeSpan(span)
}

