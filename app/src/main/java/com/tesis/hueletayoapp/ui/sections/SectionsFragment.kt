package com.tesis.hueletayoapp.ui.sections

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tesis.hueletayoapp.databinding.FragmentSectionsBinding
import com.tesis.hueletayoapp.ui.sections.adapter.SectionsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SectionsFragment : Fragment() {

    private val sectionsViewModel by viewModels<SectionsViewModel>()
    private lateinit var sectionsAdapter: SectionsAdapter
    private var _binding: FragmentSectionsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initList()
    }

    private fun initList() {
        sectionsAdapter = SectionsAdapter()
        binding.rvSections.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }

    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                sectionsViewModel.sections.collect {
                    Log.i("Huele", it.toString())
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}