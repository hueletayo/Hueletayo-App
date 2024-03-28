package com.tesis.hueletayoapp.ui.sections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tesis.hueletayoapp.R
import com.tesis.hueletayoapp.databinding.FragmentSectionsBinding


class SectionsFragment : Fragment() {

    private var _binding:FragmentSectionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}