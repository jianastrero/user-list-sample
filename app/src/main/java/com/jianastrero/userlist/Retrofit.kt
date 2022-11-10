package com.jianastrero.userlist

import com.jianastrero.userlist.api.IUserApi
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jianj on 11/10/2022.
 */

object Retrofit {

    val client = retrofit2.Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun userApi(): IUserApi =
        client.create(IUserApi::class.java)

}