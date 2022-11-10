package com.jianastrero.userlist

import org.junit.Test

/**
 * Created by jianj on 11/10/2022.
 */

class RetrofitClientClientTest {

    @Test
    fun `Test Retrofit Instance`() {
        val client = RetrofitClient.client
        assert(client.baseUrl().toUrl().toString() == BuildConfig.BASE_URL)
    }

}