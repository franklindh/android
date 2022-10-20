package com.example.pemrogmob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pemrogmob.model.Mahasiswa.MahasiswaRequest
import com.example.pemrogmob.model.Mahasiswa.MahasiswaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InsertMahasiswa : AppCompatActivity() {
    lateinit var btnCreate: Button
    lateinit var btnUpdate: Button
    lateinit var btnDelete: Button
    lateinit var btnGet: Button
    lateinit var edit_nama: EditText
    lateinit var edit_nim: EditText
    lateinit var edit_alamat: EditText
    lateinit var edit_email: EditText
    lateinit var edit_id: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_mahasiswa)

        btnGet = findViewById(R.id.btnGet)
        btnCreate = findViewById(R.id.btnCreate)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        edit_nama = findViewById(R.id.editNama)
        edit_nim = findViewById(R.id.editNim)
        edit_alamat = findViewById(R.id.editAlamat)
        edit_email = findViewById(R.id.editEmail)
        edit_id = findViewById(R.id.editId)

        initAction()
    }
    fun initAction(){
        btnCreate.setOnClickListener {
            postMahasiswa()
        }
        btnUpdate.setOnClickListener{
            updateMahasiswa()
        }
        btnDelete.setOnClickListener{
            DeleteMahasiswa()
        }
        btnGet.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@InsertMahasiswa, GetMahasiswaActivity::class.java)
            startActivity(intent)
        })
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
                Log.i("Success", "berhasil membuat mahasiswa")
            }
            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                Log.e("Gagal", t.message.toString())
            }

        })
    }

    fun updateMahasiswa() {
        var mahasiswareq = MahasiswaRequest()
        mahasiswareq.nama = edit_nama.text.toString()
        mahasiswareq.nim = edit_nim.text.toString()
        mahasiswareq.alamat = edit_alamat.text.toString()
        mahasiswareq.email = edit_email.text.toString()

        val retro = Retro().getRetroClientInstance("https://kpsi.fti.ukdw.ac.id/").create(MahasiswaAPI::class.java)
        retro.updateMahasiswa(edit_id.text.toString().toInt(), mahasiswareq).enqueue(object : Callback<MahasiswaResponse>{
            override fun onResponse(call: Call<MahasiswaResponse>, response: Response<MahasiswaResponse>) {
                Log.i("Success", "berhasil mengedit mahasiswa")
            }
            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                Log.e("Gagal", t.message.toString())
            }

        })
    }

    fun DeleteMahasiswa() {
        val retro = Retro().getRetroClientInstance("https://kpsi.fti.ukdw.ac.id/").create(MahasiswaAPI::class.java)
        retro.deleteMahasiswa(edit_nim.text.toString()).enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                val respons = response.code()
                Toast.makeText(applicationContext,"Data berhasil dihapus", Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("Gagal", t.message.toString())
            }
        })
    }
}


