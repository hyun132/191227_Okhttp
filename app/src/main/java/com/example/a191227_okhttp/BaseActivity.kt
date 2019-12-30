package com.example.a191227_okhttp

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {
    var mContext = this

    abstract fun setValues()
    abstract fun setupEvents()

}