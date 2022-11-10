package com.jianastrero.userlist.viewmodel

import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.state.UserListState

/**
 * Created by jianj on 11/11/2022.
 */

interface IUserListViewModel {

    val state: UserListState

    fun updateState(
        loadableState: LoadableState = state.loadableState,
        users: List<UserModel> = state.users,
        errorMessage: String? = state.errorMessage
    )

    fun fetchUsers()

}