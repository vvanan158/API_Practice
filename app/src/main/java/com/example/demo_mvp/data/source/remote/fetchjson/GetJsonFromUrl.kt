package com.example.demo_mvp.data.source.remote.fetchjson

import android.os.AsyncTask
import com.example.demo_mvp.data.source.remote.OnFetchDataJsonListener
import org.json.JSONArray

class GetJsonFromUrl<T>(private val mListener: OnFetchDataJsonListener<T>) :
    AsyncTask<String, Unit, String>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String {
        var data = ""
        try {
            data = ParseData().getJsonFromUrl(params[0])
        } catch (e: Exception) {
            exception = e
        }
        return data
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if (result != null && !result.isBlank()) {
            val jsonArray = JSONArray(result)
            @Suppress("UNCHECKED_CAST")
            mListener.onSuccess(ParseData().parseJsonToUsers(jsonArray) as MutableList<T>)
        } else {
            mListener.onError(exception)
        }
    }
}
