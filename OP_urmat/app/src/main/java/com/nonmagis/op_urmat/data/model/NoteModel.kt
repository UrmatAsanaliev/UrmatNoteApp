package com.nonmagis.op_urmat.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val title: String,
    val desc: String,
    val date: String
): Serializable
