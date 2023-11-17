package com.falcao.retrofitmarvelapi.adapters.configuration.retrofit

import com.falcao.retrofitmarvelapi.adapters.http.MarvelHttpService
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@Configuration
class MarvelHttpConfiguration {
    val ts = MarvelApiUtils.getCurrentTimestamp()
    val hash = MarvelApiUtils.generateHash(ts, MarvelApiUtils.PUBLIC_KEY, MarvelApiUtils.PRIVATE_KEY)

    private companion object {
        const val BASE_URL = "http://gateway.marvel.com/v1/public/"
    }

    private fun buildCLient() = OkHttpClient.Builder().build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(buildCLient())
        .build()

    @Bean
    fun marvelHttpService(): MarvelHttpService = buildRetrofit().create(MarvelHttpService::class.java)
}

object MarvelApiUtils {

    const val PUBLIC_KEY = "974d8b1a2f5fa66a8d978bb8b24b70c2"
    const val PRIVATE_KEY = "03764da00516472df9e3167b2ffdffe8ae9ec6ab"

    fun generateHash(ts: String, publicKey: String, privateKey: String): String {
        val input = "$ts$publicKey$privateKey"
        return md5(input)
    }

    private fun md5(input: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(input.toByteArray())
            val hexString = StringBuilder()

            for (byte in messageDigest) {
                hexString.append(Integer.toHexString(0xFF and byte.toInt()))
            }

            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

    fun getCurrentTimestamp(): String {
        return System.currentTimeMillis().toString()
    }
}