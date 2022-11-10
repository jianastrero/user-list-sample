package com.jianastrero.userlist

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jianastrero.userlist.api.IUserApi
import com.jianastrero.userlist.model.UserModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Created by jianj on 11/10/2022.
 */

class UserApiTest {

    private lateinit var userApi: IUserApi
    private val gson = Gson()

    @Before
    fun before() {
        userApi = Retrofit.userApi()
    }

    @Test
    fun `Test Get Users`() = runBlocking {
        val actual = userApi.getUsers()
            .sortedBy { it.id }

        val expectedJson = readFileFromResources("test.json")
        val expected = gson
            .fromJson<List<UserModel>>(
                expectedJson,
                object : TypeToken<List<UserModel>>() {}.type
            )
            .sortedBy { it.id }
            .reversed()

        assert(expected.containsAll(actual) && actual.containsAll(expected))
    }
}