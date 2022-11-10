package com.jianastrero.userlist

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jianastrero.userlist.api.IUserApi
import com.jianastrero.userlist.model.UserModel
import com.jianastrero.userlist.service.IUserService
import com.jianastrero.userlist.service.implementation.UserService
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by jianj on 11/11/2022.
 */

class UserServiceTest {

    private val userApi = RetrofitClient.client.create(IUserApi::class.java)
    private val gson = Gson()
    private val userService: IUserService  = UserService(userApi)

    @Test
    fun `Test Get User`() = runBlocking {
        val actual = userService.getUsers()
            .sortedBy { it.id }

        val expectedJson = readFileFromResources("test-distinct.json")
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