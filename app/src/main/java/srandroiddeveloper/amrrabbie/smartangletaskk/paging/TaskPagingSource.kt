package srandroiddeveloper.amrrabbie.smartangletaskk.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import srandroiddeveloper.amrrabbie.smartangletaskk.model.DataItem
import srandroiddeveloper.amrrabbie.smartangletaskk.network.ApiServices

class TaskPagingSource(private val apiServices: ApiServices) : PagingSource<Int,DataItem>() {
    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiServices.getData(currentPage)
            val responseData = mutableListOf<DataItem>()
            val data = response.body()?.data ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}