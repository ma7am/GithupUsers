package com.example.githupusers.remote

import com.example.githupusers.network.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val githubApi: GithubService by lazy {
        retrofit.create(GithubService::class.java)
    }
}