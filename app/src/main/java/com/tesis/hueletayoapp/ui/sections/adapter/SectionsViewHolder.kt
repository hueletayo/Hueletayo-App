package com.tesis.hueletayoapp.ui.sections.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.tesis.hueletayoapp.databinding.ItemSectionsBinding
import com.tesis.hueletayoapp.domain.model.SectionsInfo

class SectionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSectionsBinding.bind(view)

    fun render(sectionsInfo: SectionsInfo, onItemSelected: (SectionsInfo) -> Unit) {
        val context = binding.tvTitle.context
        binding.ivSections.setImageResource(sectionsInfo.img)
        binding.tvTitle.text = context.getString(sectionsInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivSections, newLambda = { onItemSelected(sectionsInfo) })
        }
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {

        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }

    }

}