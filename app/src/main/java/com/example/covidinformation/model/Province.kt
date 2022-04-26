package com.example.covidinformation.model

import com.google.gson.annotations.SerializedName

data class Province (
    @SerializedName("provinsi")
    val province: String,
    @SerializedName("kasus")
    val positive: Int,
    @SerializedName("sembuh")
    val recover: Int,
    @SerializedName("meninggal")
    val death: Int
        )