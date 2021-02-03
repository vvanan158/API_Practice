package com.example.demo_mvp.data.source.repositories

import com.example.demo_mvp.data.model.User
import com.example.demo_mvp.data.source.UserDataSource
import com.example.demo_mvp.data.source.remote.OnFetchDataJsonListener
import com.example.demo_mvp.data.source.remote.UserRemoteDataSource

class UserRepository private constructor(private val remote: UserDataSource.Remote) {

    private object Holder {
        val INSTANCE = UserRepository(UserRemoteDataSource.instance)
    }

    fun getUsers(listener: OnFetchDataJsonListener<User>) = remote.getUsers(listener)

    companion object {
        val instance: UserRepository by lazy {
            Holder.INSTANCE
        }
    }
}
