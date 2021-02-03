package com.example.demo_mvp.data.model

data class User(
    var id: String = "",
    var name: String = "",
    var avatar: String = ""
)

object UserEntry {
    const val PATH = "users"
    const val NAME = "login"
    const val ID = "id"
    const val URL_IMAGE = "avatar_url"
}
