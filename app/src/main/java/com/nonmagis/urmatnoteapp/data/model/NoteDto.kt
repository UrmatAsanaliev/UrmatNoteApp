package com.nonmagis.urmatnoteapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nonmagis.urmatnoteapp.domain.model.NoteModel

@Entity
data class NoteDto(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val title: String,
    val desc: String,
    val date: String
)

fun NoteDto.toDomain() = NoteModel(
    id = id,
    title = title,
    desc = desc,
    date = date,
)


fun NoteModel.toDto() = NoteDto(
    id = id,
    title = title,
    desc = desc,
    date = date
)
