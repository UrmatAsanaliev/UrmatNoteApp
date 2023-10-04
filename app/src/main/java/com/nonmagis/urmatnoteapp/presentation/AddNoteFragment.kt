package com.nonmagis.urmatnoteapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.nonmagis.urmatnoteapp.R
import com.nonmagis.urmatnoteapp.core.BaseFragment
import com.nonmagis.urmatnoteapp.databinding.FragmentAddNoteBinding
import com.nonmagis.urmatnoteapp.domain.model.NoteModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun setupUI() {
        binding().btnSave.setOnClickListener {
            initSave()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initSave() {
        val title = binding().edTitle.text.toString()
        val desc = binding().edDesc.text.toString()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val date = LocalDateTime.now().format(formatter)

        val model = NoteModel(
            title = title,
            desc= desc,
            date = date
        )
        val bundle = Bundle()
        bundle.putSerializable("model", model)
        findNavController().navigate(R.id.noteFragment, bundle)
    }
}