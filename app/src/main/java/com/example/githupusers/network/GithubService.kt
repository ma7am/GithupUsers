package com.example.githupusers.network

import com.example.githupusers.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int
    ): Response<SearchResponse>
}
/*
interface GithubService2 {
    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): User
}
*/