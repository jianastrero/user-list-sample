package com.jianastrero.userlist.service

import com.jianastrero.userlist.api.IUserApi
import com.jianastrero.userlist.model.UserModel
import javax.inject.Inject

/**
 * Created by jianj on 11/10/2022.
 */

class UserService @Inject constructor(
    private val userApi: IUserApi
) {
    suspend fun getUsers(): List<UserModel> =
        userApi.getUsers().distinctBy(UserModel::id)

    suspend fun getUser(userId: String): UserModel? =
        userApi.getUsers().firstOrNull { it.id == userId }
}