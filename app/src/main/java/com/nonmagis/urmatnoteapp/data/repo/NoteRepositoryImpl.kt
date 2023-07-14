package com.nonmagis.urmatnoteapp.data.repo

import com.nonmagis.urmatnoteapp.core.Resource
import com.nonmagis.urmatnoteapp.data.model.toDomain
import com.nonmagis.urmatnoteapp.data.model.toDto
import com.nonmagis.urmatnoteapp.data.network.NoteDatabase
import com.nonmagis.urmatnoteapp.domain.model.NoteModel
import com.nonmagis.urmatnoteapp.domain.repo.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val db: NoteDatabase
): NoteRepository {


    override fun getAllNotes(): Flow<Resource<List<NoteModel>>> = flow {
        try {
            emit(Resource.Loading())
            val data = db.dao().getAllNotes().map { it.toDomain() }
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override fun setNote(model: NoteModel): Flow<Resource<Unit>> = flow {
        try {
            emit(Resource.Loading())
            val data = db.dao().setNote(model.toDto())
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override fun deleteNote(model: NoteModel): Flow<Resource<Unit>> = flow {
        try {
            emit(Resource.Loading())
            val data = db.dao().deleteNote(model.toDto())
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override fun updateNote(model: NoteModel): Flow<Resource<Unit>> = flow {
        try {
            emit(Resource.Loading())
            val data = db.dao().updateNote(model.toDto())
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }
}