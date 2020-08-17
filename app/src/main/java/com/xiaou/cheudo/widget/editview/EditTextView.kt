package com.xiaou.cheudo.widget.editview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.design.widget.TextInputEditText
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.xiaou.cheudo.R
import com.xiaou.cheudo.extensions.backgroundColor
import com.xiaou.cheudo.extensions.textColor
import kotlinx.android.synthetic.main.widget_edit_view.view.*

/**
 * @copyright:
 * author:James
 * date:2019/6/3
 * description
 */
class EditTextView @JvmOverloads constructor(context: Context, attrs:AttributeSet? = null, defStyleRes:Int = 0)
    :ConstraintLayout(context, attrs, defStyleRes){

    private var errorMsg:CharSequence? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_edit_view, this)

        val a = context.obtainStyledAttributes(attrs, R.styleable.EditTextView)
        val icon = a.getResourceId(R.styleable.EditTextView_edit_view_icon, 0)
        val hint = a.getString(R.styleable.EditTextView_edit_hint_text)
        val space = a.getDimensionPixelSize(R.styleable.EditTextView_edit_space, 0)
        val foot = a.getString(R.styleable.EditTextView_edit_foot)
        a.recycle()

        if(icon != 0){
            edit_text_icon.setImageResource(icon)
        }else{
            edit_text_icon.visibility = View.GONE
            val params = edit_text_layout.layoutParams as ConstraintLayout.LayoutParams
            params.setMargins(0, 0, 0, 0)
            edit_text_layout.layoutParams = params
        }
        if(space != 0){
            val params = edit_text_bottom_line.layoutParams as ConstraintLayout.LayoutParams
            params.setMargins(0, space, 0, 0)
            edit_text_bottom_line.layoutParams = params
        }
        edit_text_err_msg.text = foot
        edit_text_layout.hint = hint
    }

    fun setHint(charSequence: CharSequence?){
        edit_text_layout.hint = charSequence
    }

    fun getInputText():String{
        return inputEditText.text.toString()
    }

    fun getTextInputEditText():TextInputEditText{
        return inputEditText
    }

    fun addTextWatcher(textWatcher:TextWatcher){
        inputEditText.addTextChangedListener(textWatcher)
    }

    fun removeTextWatcher(textWatcher: TextWatcher){
        inputEditText.removeTextChangedListener(textWatcher)
    }

    fun setText(charSequence: CharSequence){
        inputEditText.setText(charSequence)
    }

    fun clearText(){
        inputEditText.setText("")
    }

    fun setBottomMsg(msg:CharSequence){
        edit_text_bottom_line.backgroundColor(R.color.greyEditBg)
        edit_text_err_msg.text = msg
        edit_text_err_msg.textColor(R.color.greyEditBg)
    }

    fun getErrorMsg():CharSequence?{
        return errorMsg
    }

    fun setErrorMsg(error:CharSequence?){
        errorMsg = error
        if(error != null){
            edit_text_bottom_line.backgroundColor(R.color.colorRed)
            edit_text_err_msg.text = error
            edit_text_err_msg.textColor(R.color.colorRed)
        }else{
            edit_text_err_msg.text = ""
            edit_text_bottom_line.backgroundColor(R.color.greyEditBg)
        }
    }

    fun clearErr(){
        errorMsg = ""
        edit_text_bottom_line.backgroundColor(R.color.greyEditBg)
        edit_text_err_msg.text = ""
    }

    fun setInputType(inputType:Int){
        inputEditText.inputType = inputType
    }
}