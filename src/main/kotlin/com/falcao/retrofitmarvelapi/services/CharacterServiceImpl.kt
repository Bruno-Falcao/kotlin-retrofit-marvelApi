package com.falcao.retrofitmarvelapi.services

import com.falcao.retrofitmarvelapi.adapters.http.MarvelHttpService
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service

@Service
class CharacterServiceImpl(
    private val marvelHttpService: MarvelHttpService
) : CharacterService {


    override suspend fun listCharacters(
        ts: String,
        apiKey: String,
        hash: String
    ) = coroutineScope {
        marvelHttpService.getCharacters(
            ts,
            apiKey,
            hash
        ).body()
    }

}