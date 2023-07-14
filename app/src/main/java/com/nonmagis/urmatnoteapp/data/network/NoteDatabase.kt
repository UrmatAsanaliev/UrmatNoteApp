package com.nonmagis.urmatnoteapp.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nonmagis.urmatnoteapp.data.model.NoteDto

@Database(entities = [NoteDto::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun dao(): NoteDao
}