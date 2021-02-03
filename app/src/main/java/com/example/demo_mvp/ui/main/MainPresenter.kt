package com.example.demo_mvp.ui.main

import com.example.demo_mvp.data.model.User
import com.example.demo_mvp.data.source.remote.OnFetchDataJsonListener
import com.example.demo_mvp.data.source.repositories.UserRepository

class MainPresenter(
    private val userRepository: UserRepository
) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun getUsers() {
        userRepository.getUsers(object : OnFetchDataJsonListener<User> {
            override fun onSuccess(data: MutableList<User>) {
                view?.onGetUserSuccess(data)
            }

            override fun onError(e: Exception?) {
                view?.onError(e)
            }
        })
    }

    override fun onStart() = getUsers()

    override fun onStop() = Unit

    override fun setView(view: MainContract.View?) {
        this.view = view
    }
}
