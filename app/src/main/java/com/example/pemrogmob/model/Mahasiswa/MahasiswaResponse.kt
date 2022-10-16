package com.example.pemrogmob.model.Mahasiswa

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MahasiswaResponse {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("nama")
    var nama: String? = null

    @SerializedName("nim")
    var nim: String? = null

    @SerializedName("alamat")
    var alamat: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("foto")
    var foto: String? = null
}