package com.nonmagis.op_urmat.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nonmagis.op_urmat.ui.fragment.note.NoteAdapter
import com.nonmagis.op_urmat.data.model.NoteModel
import com.nonmagis.op_urmat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}