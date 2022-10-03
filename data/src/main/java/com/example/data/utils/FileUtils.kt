package com.example.data.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream

fun getAssetJsonData(context: Context): String? {
    var json: String? = null
    json = try {
        val inputStream: InputStream = context.assets.open(Constants.JSON_FILE_NAME)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charsets.UTF_8)
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
    return json
}