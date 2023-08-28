package com.example.githupusers.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githupusers.model.User
import com.example.githupusers.remote.RetrofitClient
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun searchUsers(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.githubApi.searchUsers(query, 1)
                if (response.isSuccessful) {
                    val users = response.body()?.items
                    _users.value = users
                } else {
                    // Handle error
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }
}