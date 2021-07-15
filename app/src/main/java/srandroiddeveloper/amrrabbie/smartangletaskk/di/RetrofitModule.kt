package srandroiddeveloper.amrrabbie.smartangletaskk.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import srandroiddeveloper.amrrabbie.smartangletaskk.network.ApiServices
import srandroiddeveloper.amrrabbie.smartangletaskk.utils.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance():ApiServices=
        Retrofit.Builder()
            .baseUrl(Constants.Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)


}