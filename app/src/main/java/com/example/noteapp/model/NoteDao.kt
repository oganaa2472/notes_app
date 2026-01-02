package com.example.noteapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("Select * from notes order by timestamp desc")
    fun getAllNotes(): Flow<List<Note>>// observing live data
}

