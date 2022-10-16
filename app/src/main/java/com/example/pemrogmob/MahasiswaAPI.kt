package com.example.pemrogmob

import com.example.pemrogmob.model.Mahasiswa.MahasiswaRequest
import com.example.pemrogmob.model.Mahasiswa.MahasiswaResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MahasiswaAPI {
    @FormUrlEncoded
    @POST("api/progmob/mhs/72200407")
     fun createMahasiswa(@Body request: MahasiswaRequest): Call<MahasiswaResponse>
}