package com.nonmagis.urmatnoteapp.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.nonmagis.urmatnoteapp.R
import com.nonmagis.urmatnoteapp.core.BaseFragment
import com.nonmagis.urmatnoteapp.core.UIState
import com.nonmagis.urmatnoteapp.databinding.FragmentNoteBinding
import com.nonmagis.urmatnoteapp.domain.model.NoteModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteFragment : BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate) {

    private val viewModel: NoteViewModel by viewModels()
    private val adapter: NoteAdapter by lazy { NoteAdapter() }
    override fun setupUI() {
        if (arguments != null) {
            val model = arguments?.getSerializable("model") as NoteModel

            viewModel.setNote(model)
            initSave()
        }


        binding().rvItems.adapter = adapter

        viewModel.getAllNotes()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.data.collect {
                    when (it) {
                        is UIState.Error -> isError(it.error)
                        is UIState.Loading -> isLoading()
                        is UIState.Success -> isSuccess(it.data)
                    }
                }
            }
        }
    }

    private fun initSave() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.setData.collect {
                    when (it) {
                        is UIState.Error -> isError(it.error)
                        is UIState.Loading -> isLoading()
                        is UIState.Success -> viewModel.getAllNotes()
                    }
                }
            }
        }
    }

    override fun setupObserver() {
        binding().btnAdd.setOnClickListener {
            findNavController().navigateUp()
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

    private fun isLoading() {}

    private fun isSuccess(data: List<NoteModel>) {
        adapter.setList(data)
    }

    private fun isError(error: String) {
        Log.e("ololo", error)
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
}