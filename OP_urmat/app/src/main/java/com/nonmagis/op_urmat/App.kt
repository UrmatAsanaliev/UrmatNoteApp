package com.nonmagis.op_urmat

import android.app.Application
import androidx.room.Room
import com.nonmagis.op_urmat.data.remote.NoteDatabase

class App: Application() {

    companion object {
        lateinit var database: NoteDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            NoteDatabase::class.java,
            "NoteDatabase"
        ).allowMainThreadQueries().build()
    }
}