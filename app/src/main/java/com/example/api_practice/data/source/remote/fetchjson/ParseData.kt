package com.example.api_practice.data.source.remote.fetchjson

import com.example.api_practice.data.model.User
import com.example.api_practice.data.model.UserEntry
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ParseData {

    fun getJsonFromUrl(url: String?): String {
        val httpURLConnection = URL(url).openConnection() as HttpURLConnection
        val stringBuilder = StringBuilder()
        try {
            httpURLConnection.apply {
                connectTimeout = TIME_OUT
                readTimeout = TIME_OUT
                requestMethod = METHOD_GET
                doOutput = true
            }.connect()
            val buffer = BufferedReader(InputStreamReader(URL(url).openStream()))
            var line: String?
            while (buffer.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
            buffer.close()
        } finally {
            httpURLConnection.disconnect()
        }
        return stringBuilder.toString()
    }

    fun parseJsonToUsers(jsonArray: JSONArray): MutableList<User> {
        val users = mutableListOf<User>()
        for (i in 0 until jsonArray.length()) {
            users.add(parseToUser(jsonArray.getJSONObject(i)))
        }
        return users
    }

    private fun parseToUser(jsonObject: JSONObject): User {
        return User().apply {
            id = jsonObject.getString(UserEntry.ID)
            name = jsonObject.getString(UserEntry.NAME)
            avatar = jsonObject.getString(UserEntry.URL_IMAGE)
        }
    }

    companion object {
        private const val TIME_OUT = 10000
        private const val METHOD_GET = "GET"
    }
}
