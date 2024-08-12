package com.imani.childregistration.Helpers

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONArray
import org.json.JSONObject

class ApiHelper(private val context: Context) {

    private val client = AsyncHttpClient(true, 80, 443) // Reuse AsyncHttpClient instance

    // POST method using ApiCallback
    fun post(api: String, jsonData: JSONObject, callback: ApiCallback) {
        val conBody = StringEntity(jsonData.toString())
        client.post(context, api, conBody, "application/json", object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONArray?
            ) {
                callback.onSuccess(response?.toString() ?: "Success with no data")
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                callback.onSuccess(response?.toString() ?: "Success with no data")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                callback.onFailure(errorResponse?.toString() ?: throwable?.toString() ?: "Unknown error")
            }
        })
    }

    // GET method using ApiCallback
    fun get(api: String, callback: ApiCallback) {
        client.get(context, api, null, "application/json", object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONArray
            ) {
                callback.onSuccess(response.toString())
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                callback.onSuccess(response?.toString() ?: "Success with no data")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {
                callback.onFailure(responseString ?: throwable?.toString() ?: "Unknown error")
            }
        })
    }

    // PUT method
    fun put(api: String, jsonData: JSONObject, callback: ApiCallback) {
        val conBody = StringEntity(jsonData.toString())
        client.put(context, api, conBody, "application/json", object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                callback.onSuccess(response?.toString() ?: "Success with no data")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                callback.onFailure(errorResponse?.toString() ?: throwable?.toString() ?: "Unknown error")
            }
        })
    }

    // DELETE method
    fun delete(api: String, jsonData: JSONObject?, callback: ApiCallback) {
        val conBody = jsonData?.let { StringEntity(it.toString()) }
        client.delete(context, api, conBody, "application/json", object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                response: JSONObject?
            ) {
                callback.onSuccess(response?.toString() ?: "Success with no data")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                throwable: Throwable?,
                errorResponse: JSONObject?
            ) {
                callback.onFailure(errorResponse?.toString() ?: throwable?.toString() ?: "Unknown error")
            }
        })
    }

    // Callback interface
    interface ApiCallback {
        fun onSuccess(response: String)
        fun onFailure(error: String)
    }
}
