package srandroiddeveloper.amrrabbie.smartangletaskk.repostry

import srandroiddeveloper.amrrabbie.smartangletaskk.network.ApiServices
import javax.inject.Inject

class TaskRepostry
@Inject
constructor(private val apiServices: ApiServices){

    suspend fun getData(page:Int)=
        apiServices.getData(page)
}