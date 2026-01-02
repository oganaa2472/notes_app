package com.example.noteapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel


@Composable
fun NoteScreen(viewModel: NoteViewModel = hiltViewModel()) {
    // displaying list
    val notes by viewModel.allNotes.collectAsState(emptyList())

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ){
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { title = it },
            label={ Text("title") }
        )
        Spacer(
            Modifier.height(8.dp)
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = content,
            onValueChange = { content = it },
            label={ Text("Note description") }
        )
        Spacer(
            Modifier.height(16.dp)
        )

        Button(onClick ={
            viewModel.insert(
                Note(0,title, content, System.currentTimeMillis())
            )
            title = ""
            content = ""
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add note")
        }
        Spacer(
            Modifier.height(16.dp)
        )
        LazyColumn() {
            items(notes) {note->
                NoteItem(note)
            }
        }


    }

}