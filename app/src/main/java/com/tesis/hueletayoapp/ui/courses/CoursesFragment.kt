package com.tesis.hueletayoapp.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tesis.hueletayoapp.R
import com.tesis.hueletayoapp.databinding.FragmentCoursesBinding
import com.tesis.hueletayoapp.databinding.FragmentSectionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoursesFragment : Fragment() {

    private var _binding: FragmentCoursesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoursesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}