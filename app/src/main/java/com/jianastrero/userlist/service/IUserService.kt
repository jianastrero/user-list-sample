package com.jianastrero.userlist.service

import com.jianastrero.userlist.model.UserModel

/**
 * Created by jianj on 11/10/2022.
 */

interface IUserService {

    suspend fun getUsers(): List<UserModel>

}