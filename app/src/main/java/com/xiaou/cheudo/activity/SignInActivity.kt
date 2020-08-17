package com.xiaou.cheudo.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.xiaou.cheudo.R
import com.xiaou.cheudo.databinding.ActivitySignInBinding

/**
 * @copyright:
 * author:James
 * date:2020/8/17
 * description
 */
class SignInActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySignInBinding>(this, R.layout.activity_sign_in)
    }

}