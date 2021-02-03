package com.example.api_practice.data.source.local

import com.example.api_practice.data.source.UserDataSource

class UserLocalDataSource : UserDataSource.Local {

    private object Holder {
        val INSTANCE = UserLocalDataSource()
    }

    companion object {
        val instance: UserLocalDataSource by lazy { Holder.INSTANCE }
    }
}
