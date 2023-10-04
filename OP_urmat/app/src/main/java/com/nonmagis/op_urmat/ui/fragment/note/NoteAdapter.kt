package com.nonmagis.op_urmat.ui.fragment.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nonmagis.op_urmat.data.model.NoteModel
import com.nonmagis.op_urmat.databinding.ItemListBinding

class NoteAdapter(
    private val click: Result
): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val list = ArrayList<NoteModel>()

    fun setList(list: List<NoteModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    //показать элементы
    inner class NoteViewHolder(private val binding: ItemListBinding):
            ViewHolder(binding.root) {
                fun bind(model: NoteModel) {
                    binding.tvTitle.text = model.title
                    binding.tvDesc.text = model.desc
                    binding.tvDate.text = model.date
                }
            }

    //создать элементы
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        ))


    //узнать количество элементов
    override fun getItemCount(): Int = list.size

    //дать данные элементам
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            click.onClick(list[position])
        }

        holder.itemView.setOnLongClickListener {
            click.onLongClick(list[position])
            true
        }
    }


    interface Result {
        fun onClick(model: NoteModel)
        fun onLongClick(model: NoteModel)
    }
}