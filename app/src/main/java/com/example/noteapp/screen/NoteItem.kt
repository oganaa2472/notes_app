package com.example.noteapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteapp.model.Note

@Composable
fun NoteItem(note: Note){
    Card(
        modifier=Modifier.fillMaxWidth().padding(8.dp)
    ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(note.title,style = MaterialTheme.typography.titleMedium).toString()

            Text(note.content,style = MaterialTheme.typography.bodyMedium)
        }
    }
}