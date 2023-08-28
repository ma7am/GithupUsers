package com.example.githupusers.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.githupusers.viewModel.SearchViewModel

@ExperimentalMaterial3Api
@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Enter a name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.searchUsers(searchText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
    }
}


/*
@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Enter a name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.searchUsers(searchText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
    }
}
 */