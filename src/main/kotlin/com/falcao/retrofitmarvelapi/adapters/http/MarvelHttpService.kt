package com.falcao.retrofitmarvelapi.adapters.http

import com.falcao.retrofitmarvelapi.models.response.CharacterWrapper
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

@Service
interface MarvelHttpService {

    @GET("/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
    ): Response<CharacterWrapper>
}