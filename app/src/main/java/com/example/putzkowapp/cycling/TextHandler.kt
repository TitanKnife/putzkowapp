package com.example.putzkowapp.cycling

import android.widget.TextView

class TextHandler
    (private var textView: TextView, private var user: String) {

    init {
        this.textView.text = this.user
    }

    fun getUser(): String{
        return this.user;
    }

    fun setUser(user: String){
        this.user = user;
        this.textView.text = this.user;
    }
}