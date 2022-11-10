package com.jianastrero.userlist

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Created by jianj on 11/11/2022.
 */



@Throws(IOException::class)
fun <T : Any> T.readFileFromResources(fileName: String): String {
    return javaClass.classLoader?.getResourceAsStream(fileName)?.use { inputStream ->
        val builder = StringBuilder()
        val reader = BufferedReader(InputStreamReader(inputStream))

        var str: String? = reader.readLine()
        while (str != null) {
            builder.append(str)
            str = reader.readLine()
        }
        return builder.toString()
    } ?: ""
}