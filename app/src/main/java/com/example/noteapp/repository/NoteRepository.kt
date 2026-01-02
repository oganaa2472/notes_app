package com.example.noteapp.repository

import com.example.noteapp.model.Note
import com.example.noteapp.model.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// decouple app layers
// easy to test able
// exposes clean methods to the viewmodel/ui
// abstracts the data source (Room,network)

// inject did automatic
class NoteRepository @Inject constructor(private val noteDoa: NoteDao) {
    suspend fun insertNote(note: Note){
        noteDoa.insert(note)
    }
    // it knows updates last values
    val allNotesInDb: Flow<List<Note>> = noteDoa.getAllNotes()
}