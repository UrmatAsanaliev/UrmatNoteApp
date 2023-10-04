package com.nonmagis.urmatnoteapp.domain.model

import java.io.Serializable

data class NoteModel(
    var id: Int = 0,
    val title: String,
    val desc: String,
    val date: String
): Serializable