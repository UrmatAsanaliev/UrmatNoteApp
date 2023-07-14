package com.nonmagis.urmatnoteapp.domain.use_case

import com.nonmagis.urmatnoteapp.domain.repo.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val repo: NoteRepository
) {
    operator fun invoke() = repo.getAllNotes()
}