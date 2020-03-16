package com.jsw.marvelheroes.Api

import com.jsw.marvelheroes.Model.ApiResponse
import com.jsw.marvelheroes.Model.ComicDataWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.sql.Types.TIMESTAMP


interface MarvelApi {
    @GET("v1/public/characters")
    fun getCharacters(
        @Query("apikey") publicKey: String?,
        @Query("hash") hash: String?,
        @Query("ts") timestamp: Long,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<ApiResponse>

    @GET("/v1/public/characters/{characterId}/comics")
    fun getComicsByCharacterId(@Path("characterId") characterId: String,
                                      @Query("apikey") apiKey: String,
                                      @Query("hash") hash: String,
                                      @Query("ts") ts: Long,
                                      @Query("offset") limit: Int,
                                      @Query("limit") orderBy: Int)
            : Call<ComicDataWrapper>
}