package com.example.api_practice.data.source.remote

interface OnFetchDataJsonListener<T> {
    fun onSuccess(data: MutableList<T>)

    fun onError(e: Exception?)
}
