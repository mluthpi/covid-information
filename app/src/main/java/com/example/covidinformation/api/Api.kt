package com.example.covidinformation.api

import com.example.covidinformation.model.IndonesiaResponse
import com.example.covidinformation.model.Province
import com.example.covidinformation.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/api/indonesia")
    fun getIndonesia(): Call<IndonesiaResponse>

    @GET("/api/indonesia/provinsi")
    fun getProvinsi(): Call<List<Province>>
}