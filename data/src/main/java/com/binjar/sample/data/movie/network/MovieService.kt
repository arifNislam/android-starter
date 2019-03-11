package com.binjar.sample.data.movie.network

import com.binjar.sample.data.BuildConfig
import com.binjar.sample.data.movie.model.MovieResponse
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY: String = BuildConfig.API_KEY

interface MovieService {

    @GET("discover/movie?api_key=$API_KEY")
    fun discover(
            @Query("primary_release_date.lte") date: String,
            @Query("page") page: Int
    ): Flowable<Response<MovieResponse>>

    @GET("movie/upcoming?api_key=$API_KEY")
    fun fetchUpcomingMovies(
            @Query("page") page: Int
    ): Flowable<Response<MovieResponse>>
}