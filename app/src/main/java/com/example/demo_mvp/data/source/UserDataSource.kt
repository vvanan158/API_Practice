package com.example.demo_mvp.data.source

import com.example.demo_mvp.data.source.remote.OnFetchDataJsonListener
import com.example.demo_mvp.data.model.User

interface UserDataSource {

    interface Remote {
        fun getUsers(listener: OnFetchDataJsonListener<User>)
    }
}
