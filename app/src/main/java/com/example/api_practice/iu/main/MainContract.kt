package com.example.api_practice.iu.main

import com.example.api_practice.data.model.User
import com.example.api_practice.iu.BasePresenter

interface MainContract {
    interface Presenter : BasePresenter<View> {
        fun getUsers()
    }

    interface View {
        fun onGetUserSuccess(users: MutableList<User>)
        fun onError(exception: Exception?)
    }
}
