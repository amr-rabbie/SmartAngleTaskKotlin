package srandroiddeveloper.amrrabbie.smartangletaskk.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import srandroiddeveloper.amrrabbie.smartangletaskk.model.DataItem
import srandroiddeveloper.amrrabbie.smartangletaskk.network.ApiServices
import srandroiddeveloper.amrrabbie.smartangletaskk.paging.TaskPagingSource
import srandroiddeveloper.amrrabbie.smartangletaskk.repostry.TaskRepostry
import javax.inject.Inject

@HiltViewModel
class TaskViewModel
@Inject
 //constructor(private val  repostry: TaskRepostry):ViewModel(){
constructor(private val  apiServices: ApiServices):ViewModel(){



   /* var dataresponse= MutableLiveData<List<DataItem>>()

    fun getData(page:Int)=viewModelScope.launch {
        repostry.getData(page).let { response->
            if(response.isSuccessful){
                dataresponse.postValue(response.body()?.data)
            }else{
                Log.d("TAG", "getData: ${response.message()}")
            }
        }
    }
    */

    val listdata=Pager(PagingConfig(pageSize = 1)){
        TaskPagingSource(apiServices)
    }.flow.cachedIn(viewModelScope)


}