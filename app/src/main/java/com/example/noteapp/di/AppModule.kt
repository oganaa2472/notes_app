package com.example.noteapp.di

import android.content.Context
import com.example.noteapp.model.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// a hilt module is a class where you define how to
// build and provide dependencies(object,like Room
// Dao, repo, retro,etc..)
// @ modile register it as a hilt component provide
// function inside are annotated with provides to
// tell hilt how to create instances
@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Provides
    @Singleton
    fun provideNotDatabase(@ApplicationContext
        context: Context
    ): NoteDatabase{
        return NoteDatabase.getDatabase(context)
    }
    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()


}