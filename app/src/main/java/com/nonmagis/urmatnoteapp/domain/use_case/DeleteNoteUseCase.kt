package com.nonmagis.urmatnoteapp.domain.use_case

import com.nonmagis.urmatnoteapp.domain.model.NoteModel
import com.nonmagis.urmatnoteapp.domain.repo.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repo: NoteRepository
){

    operator fun invoke(model: NoteModel) = repo.deleteNote(model)

}