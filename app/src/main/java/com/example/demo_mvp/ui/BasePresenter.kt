package com.example.demo_mvp.ui

interface BasePresenter<T> {

    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
