package com.nonmagis.op_urmat.data.remote

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nonmagis.op_urmat.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun dao(): NoteDao
}