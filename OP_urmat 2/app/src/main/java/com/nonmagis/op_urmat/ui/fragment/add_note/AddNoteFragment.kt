package com.nonmagis.op_urmat.ui.fragment.add_note

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.nonmagis.op_urmat.App
import com.nonmagis.op_urmat.R
import com.nonmagis.op_urmat.data.model.NoteModel
import com.nonmagis.op_urmat.databinding.FragmentAddNoteBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class AddNoteFragment : Fragment() {

    private val binding: FragmentAddNoteBinding by lazy {
        FragmentAddNoteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val id = arguments?.getString("id").toString()

            val data = arguments?.getSerializable("model") as NoteModel
            binding.edTitle.setText(data.title)
            binding.edDesc.setText(data.desc)

            binding.btnSave.setOnClickListener {
                val title = binding.edTitle.text.toString()
                val desc = binding.edDesc.text.toString()
                val formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")
                val current = LocalDateTime.now().format(formatter)
                val model = NoteModel(
                    id = data.id,
                    title = title,
                    desc = desc,
                    date = current
                )
                App.database.dao().updateNote(model)
                Toast.makeText(requireContext(), "change", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        } else {
                binding.btnSave.setOnClickListener {
                    val title = binding.edTitle.text.toString()
                    val desc = binding.edDesc.text.toString()
                    val formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")
                    val current = LocalDateTime.now().format(formatter)

                    val model = NoteModel(
                        title = title,
                        desc = desc,
                        date = current
                    )
                    App.database.dao().insertNote(model)
                    Toast.makeText(requireContext(), "save", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }
            }
        }
    }
