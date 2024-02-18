package com.app.assesmenttest.room

import androidx.paging.PagingSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.CountDownLatch

fun <PaginationKey : Any, Model : Any> PagingSource<PaginationKey, Model>.getData(): List<Model> {
    val data = mutableListOf<Model>()
    val latch = CountDownLatch(1)
    val job = CoroutineScope(Dispatchers.Main).launch {
        val loadResult: PagingSource.LoadResult<PaginationKey, Model> = this@getData.load(
            PagingSource.LoadParams.Refresh(
                key = null, loadSize = Int.MAX_VALUE, placeholdersEnabled = false
            )
        )
        when (loadResult) {
            is PagingSource.LoadResult.Error -> throw loadResult.throwable
            is PagingSource.LoadResult.Page -> data.addAll(loadResult.data)
            else -> {}
        }
        latch.countDown()
    }
    latch.await()
    job.cancel()
    return data
}