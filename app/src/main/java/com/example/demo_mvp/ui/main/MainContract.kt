package com.example.demo_mvp.ui.main

import com.example.demo_mvp.data.model.User
import com.example.demo_mvp.ui.BasePresenter

interface MainContract {

    interface View {
        fun onGetUserSuccess(users: MutableList<User>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getUsers()
    }
}
