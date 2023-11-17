package com.falcao.retrofitmarvelapi.controllers

import com.falcao.retrofitmarvelapi.services.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("marvel")
class MarvelController(
    private val characterService: CharacterService
) {

    @GetMapping
    suspend fun findCharacters(
        @RequestParam ts: String,
        @RequestParam apiKey: String,
        @RequestParam hash: String
    ) = withContext(Dispatchers.IO) {
        characterService.listCharacters(ts, apiKey, hash)
    }
}