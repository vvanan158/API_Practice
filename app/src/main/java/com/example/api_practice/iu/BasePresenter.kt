package com.example.api_practice.iu

interface BasePresenter<T> {
    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
