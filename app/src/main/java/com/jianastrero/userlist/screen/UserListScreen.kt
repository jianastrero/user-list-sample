package com.jianastrero.userlist.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // This import is used, sonar lint thinks its not
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jianastrero.userlist.component.ErrorScreen
import com.jianastrero.userlist.component.UserModelItem
import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.state.UserListState
import com.jianastrero.userlist.ui.theme.UserListSampleTheme
import com.jianastrero.userlist.viewmodel.IUserListViewModel
import com.jianastrero.userlist.viewmodel.implementation.UserListViewModel

/**
 * Created by jianj on 11/11/2022.
 */

@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    viewModel: IUserListViewModel = viewModel<UserListViewModel>()
) {
    when (viewModel.state.loadableState) {
        LoadableState.Loading -> LoadingScreen()
        LoadableState.Error -> ErrorScreen(
            errorMessage = viewModel.state.errorMessage ?: "Unknown Error"
        )
        LoadableState.Loaded -> UserListScreenContent(modifier = modifier, viewModel = viewModel)
        LoadableState.Initial -> Box(modifier)
    }

    viewModel.SetupLaunchedEffects()
}

@Composable
private fun IUserListViewModel.SetupLaunchedEffects() {
    LaunchedEffect(true) {
        fetchUsers()
    }
}

@Composable
private fun UserListScreenContent(
    modifier: Modifier,
    viewModel: IUserListViewModel
) {
    LazyColumn(modifier = modifier) {
        items(viewModel.state.users) {
            it.UserModelItem(Modifier.fillMaxSize())
        }
    }
}

@Preview
@Composable
private fun UserListPreview() {
    UserListSampleTheme {
        UserListScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = object : IUserListViewModel {
                override val state: UserListState = UserListState()

                override fun updateState(
                    loadableState: LoadableState,
                    users: List<UserModel>,
                    errorMessage: String?
                ) {
                    // Do Nothing
                }

                override fun fetchUsers() {
                    // Do Nothing
                }
            }
        )
    }
}