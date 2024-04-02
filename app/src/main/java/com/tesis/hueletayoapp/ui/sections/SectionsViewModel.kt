package com.tesis.hueletayoapp.ui.sections

import androidx.lifecycle.ViewModel
import com.tesis.hueletayoapp.data.providers.SectionsProvider
import com.tesis.hueletayoapp.domain.model.SectionsInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SectionsViewModel @Inject constructor(val sectionsProvider: SectionsProvider): ViewModel() {

    private var _sections = MutableStateFlow<List<SectionsInfo>>(emptyList())
    val sections:StateFlow<List<SectionsInfo>> = _sections

    init {
        sectionsProvider.getSections()
        _sections.value = sectionsProvider.getSections()
        }
    }