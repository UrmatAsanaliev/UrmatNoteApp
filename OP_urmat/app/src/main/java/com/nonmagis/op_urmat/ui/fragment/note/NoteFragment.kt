package com.nonmagis.op_urmat.ui.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nonmagis.op_urmat.App
import com.nonmagis.op_urmat.R
import com.nonmagis.op_urmat.data.model.NoteModel
import com.nonmagis.op_urmat.databinding.FragmentNoteBinding


class NoteFragment : Fragment(), NoteAdapter.Result {

    private val list = ArrayList<NoteModel>()
    private val adapter: NoteAdapter by lazy {
        NoteAdapter(this)
    }
    private val binding: FragmentNoteBinding by lazy {
        FragmentNoteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model = App.database.dao().getAllNotes()
        adapter.setList(model)
        binding.rvItem.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("id", "add")
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

    override fun onClick(model: NoteModel) {
        val bundle = Bundle()
        bundle.putSerializable("model", model)
        bundle.putString("id", "change")
        findNavController().navigate(R.id.addNoteFragment, bundle)
    }

    override fun onLongClick(model: NoteModel) {
        App.database.dao().deleteNote(model)
        val models = App.database.dao().getAllNotes()
        adapter.setList(models)
    }
}