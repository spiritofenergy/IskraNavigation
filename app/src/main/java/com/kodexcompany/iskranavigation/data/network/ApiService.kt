package com.kodexcompany.iskranavigation.data.network

import com.kodexcompany.iskranavigation.data.modals.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value = "/show")
    suspend fun getAllMovies(): Response<List<Movies>>
}