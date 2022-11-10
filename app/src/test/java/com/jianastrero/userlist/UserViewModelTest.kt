package com.jianastrero.userlist

import com.jianastrero.userlist.api.IUserApi
import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.service.UserService
import com.jianastrero.userlist.viewmodel.IUserViewModel
import com.jianastrero.userlist.viewmodel.implementation.UserViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by jianj on 11/11/2022.
 */

class UserViewModelTest {

    private val userApi = RetrofitClient.client.create(IUserApi::class.java)
    private val userService: UserService = UserService(userApi)
    private val viewModel: IUserViewModel = UserViewModel(userService)

    @Test
    fun `Test Fetch Users`() = runBlocking {
        assert(viewModel.state.loadableState == LoadableState.Initial)
        assert(viewModel.state.user == null)
        assert(viewModel.state.errorMessage == null)

        viewModel.fetchUser("1")
        delay(5000)

        assert(viewModel.state.loadableState == LoadableState.Loaded)
        assert(viewModel.state.user != null)
        assert(viewModel.state.errorMessage == null)
    }

}