package com.jianastrero.userlist.api

import com.jianastrero.userlist.model.UserModel
import retrofit2.http.GET

/**
 * Created by jianj on 11/10/2022.
 */

interface IUserApi {

    @GET("erni-ph-mobile-team/c5b401c4fad718da9038669250baff06/raw/7e390e8aa3f7da4c35b65b493fcbfea3da55eac9/test.json")
    suspend fun getUsers(): List<UserModel>

}