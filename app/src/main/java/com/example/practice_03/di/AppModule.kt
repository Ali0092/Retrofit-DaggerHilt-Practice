package com.example.practice_03.di


import com.example.practice_03.Constant
import com.example.practice_03.api.SimpleApi
import com.example.practice_03.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //All the Dependencies we want to Inject into our Application...

    //Retrofit Singleton Instance...
    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit=Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //Creating and Assigning Retrofit instance to Simple API variable..
    @Provides
    @Singleton
    fun getApi(retrofit: Retrofit):SimpleApi=retrofit.create(SimpleApi::class.java)

    //Singleton Instance of Repository....
    @Provides
    @Singleton
    fun getRepo(api: SimpleApi): Repository=Repository(api)
}