package com.jianastrero.userlist.di

import com.jianastrero.userlist.RetrofitClient
import com.jianastrero.userlist.api.IUserApi
import com.jianastrero.userlist.service.IUserService
import com.jianastrero.userlist.service.implementation.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by jianj on 11/11/2022.
 */


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit =
        RetrofitClient.client

    @Provides
    @Singleton
    fun userApi(client: Retrofit): IUserApi =
        client.create(IUserApi::class.java)

    @Provides
    @Singleton
    fun userService(userApi: IUserApi): IUserService =
        UserService(userApi)

}