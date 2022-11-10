package com.jianastrero.userlist

import org.junit.Test

/**
 * Created by jianj on 11/10/2022.
 */

class RetrofitClientTest {

    @Test
    fun `Test Retrofit Instance`() {
        val client = Retrofit.client
        assert(client.baseUrl().url().toString() == "https://gist.githubusercontent.com/")
    }

}