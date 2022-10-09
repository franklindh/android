package com.example.pemrogmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemrogmob.adapter.PetaniAdapter
import com.example.pemrogmob.adapter.PetaniCVAdapter
import com.example.pemrogmob.model.Petani

class SampleCardView : AppCompatActivity() {
    lateinit var rvSample: RecyclerView
    lateinit var petaniadapter : PetaniCVAdapter
    lateinit var lPetani : List<Petani>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_card_view)

        rvSample = findViewById(R.id.rvCardView)

        lPetani = listOf(
            Petani(user = "U01", nama = "Tes", jumlahLahan = "100", identifikasi = "50", tambahLahan = "50"),
            Petani(user = "U02", nama = "RT", jumlahLahan = "100", identifikasi = "50", tambahLahan = "50")
        )

        petaniadapter = PetaniCVAdapter(lPetani)

        rvSample.apply {
            layoutManager = LinearLayoutManager(this@SampleCardView)
            adapter = petaniadapter
        }
    }
}