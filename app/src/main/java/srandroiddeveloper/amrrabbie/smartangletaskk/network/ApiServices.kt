package srandroiddeveloper.amrrabbie.smartangletaskk.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import srandroiddeveloper.amrrabbie.smartangletaskk.model.ApiResponse
import srandroiddeveloper.amrrabbie.smartangletaskk.utils.Constants

interface ApiServices {

    @GET(Constants.End_Point)
    suspend fun getData(
        @Query("page") page:Int
    ):Response<ApiResponse>
}