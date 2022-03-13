package com.example.practice_03.di

import androidx.appcompat.app.AppCompatActivity
import com.example.practice_03.Constant
import com.example.practice_03.api.SimpleApi
import com.example.practice_03.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(AppCompatActivity::class)
object AppModule {


    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit=Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getApi(retrofit: Retrofit):SimpleApi=
        retrofit.create(SimpleApi::class.java)
}