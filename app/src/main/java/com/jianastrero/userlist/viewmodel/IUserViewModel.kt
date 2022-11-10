package com.jianastrero.userlist.viewmodel

import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.state.UserState

/**
 * Created by jianj on 11/11/2022.
 */

interface IUserViewModel {

    val state: UserState

    fun updateState(
        loadableState: LoadableState = state.loadableState,
        user: UserModel? = state.user,
        errorMessage: String? = state.errorMessage
    )

    fun fetchUser(userId: String)
}