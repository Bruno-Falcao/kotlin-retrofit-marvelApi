package com.falcao.retrofitmarvelapi.services

import com.falcao.retrofitmarvelapi.models.response.CharacterWrapper

interface CharacterService {
    suspend fun listCharacters(): CharacterWrapper?
}