package com.example.pemrogmob

import com.example.pemrogmob.model.Mahasiswa.MahasiswaRequest
import com.example.pemrogmob.model.Mahasiswa.MahasiswaResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface MahasiswaAPI {
    @GET("api/progmob/mhs/72200407")
    fun getMahasiswa(): Call<MahasiswaResponse>

    @POST("api/progmob/mhs/create?nim_progmob=72200407")
     fun createMahasiswa(@Body request: MahasiswaRequest): Call<MahasiswaResponse>

    @POST("api/progmob/mhs/update?{id}&nim_progmob=72200407")
    fun updateMahasiswa(@Path("id") id:Int, @Body request: MahasiswaRequest): Call<MahasiswaResponse>

    @POST("api/progmob/mhs/delete?{nim}&nim_progmob=72200407")
    fun deleteMahasiswa(@Path("nim") nim:String): Call<String>
}