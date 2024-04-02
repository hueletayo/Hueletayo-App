package com.tesis.hueletayoapp.ui.sections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tesis.hueletayoapp.R
import com.tesis.hueletayoapp.domain.model.SectionsInfo

class SectionsAdapter(
    private var sectionsList: List<SectionsInfo> = emptyList(),
    private val onItemSelected: (SectionsInfo) -> Unit
) :
    RecyclerView.Adapter<SectionsViewHolder>() {

    fun updateList(list: List<SectionsInfo>) {
        sectionsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionsViewHolder {
        return SectionsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sections, parent, false)
        )
    }

    override fun getItemCount() = sectionsList.size

    override fun onBindViewHolder(holder: SectionsViewHolder, position: Int) {
        holder.render(sectionsList[position], onItemSelected)
    }
}