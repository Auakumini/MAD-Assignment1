package com.example.assignment1

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(navController: NavHostController) {
    val context = LocalContext.current
    val activity = context as? Activity

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Book List") },
                navigationIcon = {
                    // Check if activity is not null to show back button
                    if (activity != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
            )
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            val books = BookRepository.getBooks() // Fetch the list of books
            items(books) { book ->
                Text(
                    text = book.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent(context, BookDetailActivity::class.java).apply {
                                putExtra("bookId", book.id)
                            }
                            context.startActivity(intent)
                        }
                        .padding(8.dp)
                )
            }
        }
    }
}
