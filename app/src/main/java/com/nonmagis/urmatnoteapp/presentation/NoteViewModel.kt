package com.nonmagis.urmatnoteapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nonmagis.urmatnoteapp.core.Resource
import com.nonmagis.urmatnoteapp.core.UIState
import com.nonmagis.urmatnoteapp.domain.model.NoteModel
import com.nonmagis.urmatnoteapp.domain.use_case.DeleteNoteUseCase
import com.nonmagis.urmatnoteapp.domain.use_case.GetAllNotesUseCase
import com.nonmagis.urmatnoteapp.domain.use_case.SetNoteUseCase
import com.nonmagis.urmatnoteapp.domain.use_case.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val setNoteUseCase: SetNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
): ViewModel() {

    private val _data = MutableStateFlow<UIState<List<NoteModel>>>(UIState.Loading())
    val data = _data.asStateFlow()

    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllNotesUseCase().collect {
                when (it) {
                    is Resource.Error -> _data.value = UIState.Error(it.message ?: "Unknown error")
                    is Resource.Loading -> _data.value = UIState.Loading()
                    is Resource.Success -> _data.value = UIState.Success(it.data!!)
                }
            }
        }
    }

    private val _setData = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val setData = _setData.asStateFlow()
    fun setNote(model: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            setNoteUseCase(model).collect {
                when (it) {
                    is Resource.Error -> _setData.value = UIState.Error(it.message ?: "Unknown error")
                    is Resource.Loading -> _setData.value = UIState.Loading()
                    is Resource.Success -> _setData.value = UIState.Success(it.data!!)
                }
            }
        }
    }



}