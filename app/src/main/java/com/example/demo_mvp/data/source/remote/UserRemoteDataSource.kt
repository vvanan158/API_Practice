package com.example.demo_mvp.data.source.remote

import com.example.demo_mvp.data.model.User
import com.example.demo_mvp.data.model.UserEntry
import com.example.demo_mvp.data.source.UserDataSource
import com.example.demo_mvp.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.demo_mvp.utils.Constant

class UserRemoteDataSource : UserDataSource.Remote {

    private val baseUrl = Constant.BASE_URL + UserEntry.PATH

    private object Holder {
        val INSTANCE = UserRemoteDataSource()
    }

    override fun getUsers(listener: OnFetchDataJsonListener<User>) {
        GetJsonFromUrl(listener).execute(baseUrl)
    }

    companion object {
        val instance: UserRemoteDataSource by lazy {
            Holder.INSTANCE
        }
    }
}
