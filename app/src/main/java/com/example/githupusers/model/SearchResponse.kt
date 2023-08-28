package com.example.githupusers.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("items") val items: List<User>
)
data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login") val lOGIN: String

)
