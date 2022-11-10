package com.jianastrero.userlist.viewmodel.preview

import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.state.UserListState
import com.jianastrero.userlist.viewmodel.IUserListViewModel

/**
 * Created by jianj on 11/11/2022.
 */

class UserListViewModelPreview : IUserListViewModel {

    override val state: UserListState
        get() = UserListState()

    override fun updateState(
        loadableState: LoadableState,
        users: List<UserModel>,
        errorMessage: String?
    ) {
        // It's a Preview, Do Nothing
    }

    override fun fetchUsers() {
        // It's a Preview, Do Nothing
    }
}