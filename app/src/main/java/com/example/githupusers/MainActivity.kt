package com.example.githupusers

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.githupusers.model.User
import com.example.githupusers.view.SearchScreen
import com.example.githupusers.viewModel.SearchViewModel




class MainActivity : ComponentActivity() {
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchApp(viewModel)
        }
    }
}


//fun SearchApp(viewModel: SearchViewModel = viewModel())
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchApp(viewModel: SearchViewModel ) {
    //val users: List<User> by viewModel.users.observeAsState(emptyList())
    val users by viewModel.users.observeAsState(emptyList())
    //val users = viewModel.users.observeAsState(emptyList()).value

    Scaffold(
        topBar = { TopAppBar(title = { Text("GitHub User Search") }) },
        content = {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                SearchScreen(viewModel)

                Spacer(modifier = Modifier.height(16.dp))

                if (users.isNotEmpty()) {
                    UserList(users = users)
                }
            }
        }
    )
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = rememberImagePainter(user.avatarUrl),
                    contentDescription = "Profile Photo",
                    modifier = Modifier.size(150.dp).border(BorderStroke(3.dp, Color.Blue),
                        RectangleShape)

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(user.id.toString())
                Text(user.lOGIN.toString())
            }
        }
    }
}