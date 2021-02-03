package com.example.api_practice.data.source.repositories

import com.example.api_practice.data.model.User
import com.example.api_practice.data.source.UserDataSource
import com.example.api_practice.data.source.local.UserLocalDataSource
import com.example.api_practice.data.source.remote.OnFetchDataJsonListener
import com.example.api_practice.data.source.remote.UserRemoteDataSource

class UserRepository private constructor(
    private val remote: UserDataSource.Remote,
    private val local: UserDataSource.Local
) {

    private object Holder {
        val INSTANT = UserRepository(
            UserRemoteDataSource.instant,
            UserLocalDataSource.instance
        )
    }

    fun getUsers(listener: OnFetchDataJsonListener<User>) = remote.getUsers(listener)

    companion object {
        val instant: UserRepository by lazy {
            Holder.INSTANT
        }
    }
}
