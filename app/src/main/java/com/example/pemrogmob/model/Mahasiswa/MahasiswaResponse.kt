package com.example.pemrogmob.model.Mahasiswa

import com.example.pemrogmob.model.ResponseUsersItem
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MahasiswaResponse(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("nama")
    @Expose
    var nama: String? = null,

    @SerializedName("nim")
    @Expose
    var nim: String? = null,

    @SerializedName("alamat")
    @Expose
    var alamat: String? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("foto")
    @Expose
    var foto: String? = null
)


