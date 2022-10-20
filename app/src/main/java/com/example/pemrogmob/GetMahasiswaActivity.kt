package com.example.pemrogmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemrogmob.adapter.MahasiswaAdapter
import com.example.pemrogmob.model.Mahasiswa.MahasiswaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMahasiswaActivity : AppCompatActivity() {
    lateinit var rvMahasiswa: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_mahasiswa)

        rvMahasiswa = findViewById(R.id.rvMahasiswa)

            val retro = Retro().getRetroClientInstance("https://kpsi.fti.ukdw.ac.id/").create(MahasiswaAPI::class.java)
            retro.getMahasiswa().enqueue(object : Callback<MahasiswaResponse> {
                override fun onResponse(call: Call<MahasiswaResponse>, response: Response<MahasiswaResponse>) {
                    var list = response.body()
                    rvMahasiswa.apply{
                        layoutManager = LinearLayoutManager(this@GetMahasiswaActivity)
                        adapter = MahasiswaAdapter(list as List<MahasiswaResponse>?)
                    }
                }
                override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                    Toast.makeText(this@GetMahasiswaActivity, t.localizedMessage,
                        Toast.LENGTH_SHORT).show()
                }

            })
    }
}