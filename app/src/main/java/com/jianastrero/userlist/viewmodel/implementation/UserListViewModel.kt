package com.jianastrero.userlist.viewmodel.implementation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.extension.launch
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.service.UserService
import com.jianastrero.userlist.state.UserListState
import com.jianastrero.userlist.viewmodel.IUserListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by jianj on 11/11/2022.
 */

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel(), IUserListViewModel {

    private var _state: UserListState by mutableStateOf(UserListState())
    override val state: UserListState
        get() = _state

    override fun updateState(
        loadableState: LoadableState,
        users: List<UserModel>,
        errorMessage: String?
    ) {
        _state = _state.copy(
            loadableState = loadableState,
            users = users,
            errorMessage = errorMessage
        )
    }

    override fun fetchUsers() = launch {
        updateState(loadableState = LoadableState.Initial)

        try {
            updateState(
                loadableState = LoadableState.Loaded,
                users = userService.getUsers(),
                errorMessage = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            updateState(
                loadableState = LoadableState.Error,
                users = emptyList(),
                errorMessage = e.message
            )
        }
    }
}