package com.jianastrero.userlist.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Created by jianj on 11/11/2022.
 */

fun ViewModel.launch(
    coroutineContext: CoroutineContext = Dispatchers.IO,
    block: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch(coroutineContext, block = block)
}