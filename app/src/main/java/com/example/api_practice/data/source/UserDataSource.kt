package com.example.api_practice.data.source

import com.example.api_practice.data.model.User
import com.example.api_practice.data.source.remote.OnFetchDataJsonListener

interface UserDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getUsers(listener: OnFetchDataJsonListener<User>)
    }
}
