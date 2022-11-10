package com.jianastrero.userlist

import com.jianastrero.userlist.api.IUserApi
import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.service.UserService
import com.jianastrero.userlist.viewmodel.IUserListViewModel
import com.jianastrero.userlist.viewmodel.implementation.UserListViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by jianj on 11/11/2022.
 */

class UserListViewModelTest {

    private val userApi = RetrofitClient.client.create(IUserApi::class.java)
    private val userService: UserService = UserService(userApi)
    private val viewModel: IUserListViewModel = UserListViewModel(userService)

    @Test
    fun `Test Fetch Users`() = runBlocking {
        assert(viewModel.state.loadableState == LoadableState.Initial)
        assert(viewModel.state.users.isEmpty())
        assert(viewModel.state.errorMessage == null)

        viewModel.fetchUsers()
        delay(5000)

        assert(viewModel.state.loadableState == LoadableState.Loaded)
        assert(viewModel.state.users.isNotEmpty())
        assert(viewModel.state.errorMessage == null)
    }

}