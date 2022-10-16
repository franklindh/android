package com.example.pemrogmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.pemrogmob.model.Mahasiswa.MahasiswaRequest
import com.example.pemrogmob.model.Mahasiswa.MahasiswaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InsertMahasiswa : AppCompatActivity() {
    lateinit var btnCreate: Button
    lateinit var edit_nama: EditText
    lateinit var edit_nim: EditText
    lateinit var edit_alamat: EditText
    lateinit var edit_email: EditText
    lateinit var tv_nama: TextView
    lateinit var tv_nim: TextView
    lateinit var tv_alamat: TextView
    lateinit var tv_email: TextView
    lateinit var tv_id: TextView
    lateinit var tv_foto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_mahasiswa)

        btnCreate = findViewById(R.id.btnCreate)
        edit_nama = findViewById(R.id.editNama)
        edit_nim = findViewById(R.id.editNim)
        edit_alamat = findViewById(R.id.editAlamat)
        edit_email = findViewById(R.id.editEmail)
        tv_nama = findViewById(R.id.tv_nama)
        tv_nim= findViewById(R.id.tv_nim)
        tv_alamat = findViewById(R.id.tv_alamat)
        tv_email = findViewById(R.id.tv_email)
        tv_id = findViewById(R.id.tv_id)
        tv_foto= findViewById(R.id.tv_foto)

        iniAction()
    }
    fun iniAction(){
        btnCreate.setOnClickListener {
            postMahasiswa()
        }
    }

    fun postMahasiswa() {
        var mahasiswareq = MahasiswaRequest()
        mahasiswareq.nama = edit_nama.text.toString()
        mahasiswareq.nim = edit_nim.text.toString()
        mahasiswareq.alamat = edit_alamat.text.toString()
        mahasiswareq.email = edit_email.text.toString()

        val retro = Retro().getRetroClientInstance("https://kpsi.fti.ukdw.ac.id/").create(MahasiswaAPI::class.java)
        retro.createMahasiswa(mahasiswareq).enqueue(object : Callback<MahasiswaResponse>{
            override fun onResponse(call: Call<MahasiswaResponse>, response: Response<MahasiswaResponse>) {
                val mahasiswa = response.body()
                tv_id.text = mahasiswa!!.id.toString()
                tv_nama.text = mahasiswa!!.nama.toString()
                tv_nim.text = mahasiswa!!.nim.toString()
                tv_alamat.text = mahasiswa!!.alamat.toString()
                tv_email.text = mahasiswa!!.email.toString()
                tv_foto.text = mahasiswa!!.foto.toString()
            }
            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
               Log.e("Gagal", t.message.toString())
            }

        })
    }
}


