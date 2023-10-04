package com.nonmagis.urmatnoteapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nonmagis.urmatnoteapp.databinding.ItemNoteBinding
import com.nonmagis.urmatnoteapp.domain.model.NoteModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val list = ArrayList<NoteModel>()

    fun setList(list: List<NoteModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding):
            ViewHolder(binding.root) {
                fun bind(model: NoteModel) {
                    binding.rvTitle.text = model.title
                    binding.rvDesc.text = model.desc
                    binding.rvDate.text = model.date
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

}