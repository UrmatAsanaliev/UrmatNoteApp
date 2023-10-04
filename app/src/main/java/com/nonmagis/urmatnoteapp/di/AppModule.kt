package com.nonmagis.urmatnoteapp.di

import android.content.Context
import androidx.room.Room
import com.nonmagis.urmatnoteapp.data.network.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "database"
    ).allowMainThreadQueries().build()
}