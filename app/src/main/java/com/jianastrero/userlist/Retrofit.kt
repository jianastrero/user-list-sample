package com.jianastrero.userlist

import com.jianastrero.userlist.api.IUserApi
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jianj on 11/10/2022.
 */

object Retrofit {

    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun userApi(): IUserApi =
        retrofit.create(IUserApi::class.java)

}