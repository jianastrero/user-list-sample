package com.jianastrero.userlist.state

import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.model.UserModel

/**
 * Created by jianj on 11/11/2022.
 */

data class UserListState(
    val loadableState: LoadableState<List<UserModel>>
)
