package com.nonmagis.op_urmat.data.remote

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nonmagis.op_urmat.data.model.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteModel")
    fun getAllNotes(): List<NoteModel>

    @Insert
    fun insertNote(model: NoteModel)

    @Delete
    fun deleteNote(model: NoteModel)

    @Update
    fun updateNote(model: NoteModel)
}