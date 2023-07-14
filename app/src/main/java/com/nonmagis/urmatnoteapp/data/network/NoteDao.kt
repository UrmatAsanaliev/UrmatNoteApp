package com.nonmagis.urmatnoteapp.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nonmagis.urmatnoteapp.core.Resource
import com.nonmagis.urmatnoteapp.data.model.NoteDto
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteDto")
    suspend fun getAllNotes(): List<NoteDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setNote(model: NoteDto)

    @Delete
    suspend fun deleteNote(model: NoteDto)

    @Update
    suspend fun updateNote(model: NoteDto)
}