package com.jianastrero.userlist.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jianastrero.userlist.component.ErrorScreen
import com.jianastrero.userlist.enumeration.LoadableState
import com.jianastrero.userlist.viewmodel.IUserViewModel
import com.jianastrero.userlist.viewmodel.implementation.UserViewModel

/**
 * Created by jianj on 11/11/2022.
 */

@Composable
fun UserScreen(
    userId: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: IUserViewModel = hiltViewModel<UserViewModel>()
) {
    val (loadableState, _, errorMessage) = viewModel.state

    when (loadableState) {
        LoadableState.Loading -> LoadingScreen()
        LoadableState.Error -> ErrorScreen(errorMessage = errorMessage ?: "Unknown Error")
        LoadableState.Loaded -> UserScreenContent(
            navController = navController,
            modifier = modifier,
            viewModel = viewModel
        )
        LoadableState.Initial -> Box(modifier)
    }

    viewModel.SetupLaunchedEffects(userId = userId)
}

@Composable
private fun IUserViewModel.SetupLaunchedEffects(userId: String) {
    LaunchedEffect(userId) {
        fetchUser(userId)
    }
}

@Composable
private fun UserScreenContent(
    navController: NavController,
    modifier: Modifier,
    viewModel: IUserViewModel
) {
    val user = viewModel.state.user ?: return

    Column(modifier = modifier) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = user.imageUrl,
                contentDescription = user.name,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(12.dp)
                    .size(32.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
        Text(
            text = user.name,
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@Preview
@Composable
private fun UserScreenPreview() {
    UserScreen("1", rememberNavController())
}