package com.app.assesmenttest.ui.screens.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.app.assesmenttest.room.entity.Medicine
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(pager: Pager<Int, Medicine>) : ViewModel() {

    val medicineFlow =
        pager.flow.cachedIn(viewModelScope)
}