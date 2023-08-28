package com.example.githupusers.UserDetails
/*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.githupusers.model.User
import com.example.githupusers.network.GithubService2
import com.example.githupusers.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun UserDetailScreen(navController: NavController, userId: Int) {
    val user by remember(userId) { mutableStateOf<User?>(null) }

    LaunchedEffect(userId) {
        val githubService = RetrofitClient.create(GithubService2::class.java)
        try {
            val fetchedUser = withContext(Dispatchers.IO) {
                githubService.getUserDetails(userId.toString())
            }
            user.value = fetchedUser
        } catch (e: Exception) {
            // Handle error
        }
    }

    // Display user details
    user.value?.let { userDetails ->
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(userDetails.avatarUrl),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(150.dp)
                    .border(BorderStroke(3.dp, Color.Blue), RectangleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("ID: ${userDetails.id}")
            Text("Username: ${userDetails.login}")
        }
    }
}
*/
