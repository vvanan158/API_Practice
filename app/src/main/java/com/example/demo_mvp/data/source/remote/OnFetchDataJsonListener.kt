package com.example.demo_mvp.data.source.remote

interface OnFetchDataJsonListener<T> {
    
    fun onSuccess(data: MutableList<T>)
    fun onError(e: Exception?)
}
