package com.nonmagis.urmatnoteapp.domain.repo

import com.nonmagis.urmatnoteapp.core.Resource
import com.nonmagis.urmatnoteapp.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<Resource<List<NoteModel>>>

    fun setNote(model: NoteModel): Flow<Resource<Unit>>

    fun deleteNote(model: NoteModel): Flow<Resource<Unit>>

    fun updateNote(model: NoteModel): Flow<Resource<Unit>>

}