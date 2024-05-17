package com.falcao.retrofitmarvelapi.adapters.configuration.retrofit

import com.falcao.retrofitmarvelapi.adapters.http.MarvelHttpService
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest

@Configuration
class MarvelHttpConfiguration {
    private companion object {
        val BASE_URL = "https://gateway.marvel.com/v1/public/"
    }

    private fun buildCLient() = OkHttpClient.Builder().build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(buildCLient())
        .build()

    @Bean
    fun marvelHttpService() = buildRetrofit().create(MarvelHttpService::class.java)

}

object Utils {
    var public_key: String = System.getenv("PB_KEY")
    var private_key: String = System.getenv("PV_KEY")

    fun generateHash(ts: Long): String {
        val input = "$ts$private_key$public_key"
        val bytes = MessageDigest.getInstance("MD5").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
