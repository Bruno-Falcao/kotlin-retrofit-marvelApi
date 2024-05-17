package com.falcao.retrofitmarvelapi.services

import com.falcao.retrofitmarvelapi.adapters.configuration.retrofit.Utils
import com.falcao.retrofitmarvelapi.adapters.http.MarvelHttpService
import com.falcao.retrofitmarvelapi.models.response.CharacterWrapper
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service

@Service
class CharacterService(
    private val marvelHttpService: MarvelHttpService
) {

    suspend fun listCharacters(): CharacterWrapper? = coroutineScope {
        val ts = System.currentTimeMillis()
        val apiKey = Utils.public_key
        System.getenv("PB_KEY")

        val hash = Utils.generateHash(ts)
        marvelHttpService.getCharacters(
            ts,
            apiKey,
            hash
        ).body()
    }
}