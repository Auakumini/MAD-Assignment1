package com.example.assignment1

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(bookId: Int) {
    val activity = LocalContext.current as? Activity
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book Details") },
                navigationIcon = {
                    IconButton(onClick = { activity?.finish() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = topAppBarColors(
        )
            )
        }
    ) { paddingValues ->
        // Fetch the book details using the book ID
        val book = BookRepository.getBookById(bookId)
        book?.let {
            Column(modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)) {
                Text(text = "Title: ${it.title}", style = MaterialTheme.typography.headlineMedium)
                Text(text = "Author: ${it.author}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Description: ${it.description}", style = MaterialTheme.typography.bodyMedium)
            }
        } ?: Text("Book not found", style = MaterialTheme.typography.headlineMedium)
    }
}
