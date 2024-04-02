package com.tesis.hueletayoapp.ui.sections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.tesis.hueletayoapp.databinding.FragmentSectionsBinding
import com.tesis.hueletayoapp.domain.model.SectionsInfo
import com.tesis.hueletayoapp.domain.model.SectionsModel
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
        sectionsAdapter = SectionsAdapter(onItemSelected = {
            it.name
            val type = when (it) {
                SectionsInfo.LvlUno -> SectionsModel.Nivel1
                SectionsInfo.LvlDos -> SectionsModel.Nivel2
                SectionsInfo.LvlTres -> SectionsModel.Nivel3
                SectionsInfo.LvlCuatro -> SectionsModel.Nivel4
                SectionsInfo.LvlCinco -> SectionsModel.Nivel5
                SectionsInfo.LvlSeis -> SectionsModel.Nivel6
                SectionsInfo.LvlSiete -> SectionsModel.Nivel7
                SectionsInfo.LvlOcho -> SectionsModel.Nivel8
            }

            findNavController().navigate(
                SectionsFragmentDirections.actionSectionsFragmentToSectionsDetailActivity(type)
            )
        })

        binding.rvSections.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = sectionsAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                sectionsViewModel.sections.collect {
                    //CAMBIOS EN SECTIONS
                    sectionsAdapter.updateList(it)
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