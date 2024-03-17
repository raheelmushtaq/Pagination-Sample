package com.app.assesmenttest.ui.presentation.feature_cars.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.app.assesmenttest.room.entity.Cars
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(pager: Pager<Int, Cars>) : ViewModel() {

    val medicineFlow =
        pager.flow.cachedIn(viewModelScope)
}