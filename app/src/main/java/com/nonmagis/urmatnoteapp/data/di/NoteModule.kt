package com.nonmagis.urmatnoteapp.data.di

import com.nonmagis.urmatnoteapp.data.repo.NoteRepositoryImpl
import com.nonmagis.urmatnoteapp.domain.repo.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NoteModule {

    @Binds
    fun bindNoteRepo(
        noteRepositoryImpl: NoteRepositoryImpl
    ): NoteRepository

}