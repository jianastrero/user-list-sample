package com.jianastrero.userlist.enumeration

/**
 * Created by jianj on 11/11/2022.
 */

sealed class LoadableState<T : Any> {

    object Initial : LoadableState<Unit>()
    object Loading : LoadableState<Unit>()
    class Error(val message: String) : LoadableState<Unit>()
    class Loaded<T : Any>(val data: T) : LoadableState<T>()

}
