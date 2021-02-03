package com.example.api_practice.data.source.remote

import com.example.api_practice.data.model.User
import com.example.api_practice.data.model.UserEntry
import com.example.api_practice.data.source.UserDataSource
import com.example.api_practice.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.api_practice.utils.Constant

class UserRemoteDataSource : UserDataSource.Remote {

    private val baseUrl = Constant.BASE_URL + UserEntry.PATH

    private object Holder {
        val INSTANT = UserRemoteDataSource()
    }

    override fun getUsers(listener: OnFetchDataJsonListener<User>) {
        GetJsonFromUrl(listener).execute(baseUrl)
    }

    companion object {
        val instant: UserRemoteDataSource by lazy {
            Holder.INSTANT
        }
    }
}
