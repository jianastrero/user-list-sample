package com.jianastrero.userlist.service.implementation

import com.jianastrero.userlist.api.IUserApi
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.service.IUserService
import javax.inject.Inject

/**
 * Created by jianj on 11/10/2022.
 */

class UserService @Inject constructor(
    private val userApi: IUserApi
) : IUserService {

    override suspend fun getUsers(): List<UserModel> =
        userApi.getUsers().distinctBy(UserModel::id)

}