package com.jianastrero.userlist.viewmodel.implementation

import androidx.compose.runtime.getValue // Ignore SonarLint Issue - Needed for line #25
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue // Ignore SonarLint Issue - Needed for line #25
import androidx.lifecycle.ViewModel
import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.extension.launch
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.service.UserService
import com.jianastrero.userlist.state.UserState
import com.jianastrero.userlist.viewmodel.IUserViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by jianj on 11/11/2022.
 */

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel(), IUserViewModel {

    private var _state: UserState by mutableStateOf(UserState())
    override val state: UserState
        get() = _state

    override fun updateState(
        loadableState: LoadableState,
        user: UserModel?,
        errorMessage: String?
    ) {
        _state = _state.copy(
            loadableState = loadableState,
            user = user,
            errorMessage = errorMessage
        )
    }

    override fun fetchUser(userId: String) = launch {
        updateState(loadableState = LoadableState.Initial)

        try {
            updateState(
                loadableState = LoadableState.Loaded,
                user = userService.getUser(userId),
                errorMessage = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            updateState(
                loadableState = LoadableState.Error,
                user = null,
                errorMessage = e.message
            )
        }
    }
}