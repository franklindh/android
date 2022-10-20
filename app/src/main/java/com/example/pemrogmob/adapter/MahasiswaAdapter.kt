package com.example.pemrogmob.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pemrogmob.R
import com.example.pemrogmob.model.Mahasiswa.MahasiswaResponse
import com.example.pemrogmob.model.ResponseUsersItem

class MahasiswaAdapter(val mahasiswa: List<MahasiswaResponse>?):
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MahasiswaAdapter.MahasiswaHolder {
        return MahasiswaHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_mahasiswa, parent, false))
    }
    override fun onBindViewHolder(holder: MahasiswaAdapter.MahasiswaHolder, position: Int) {
        holder.bindMahasiswa(mahasiswa?.get(position))
    }

    class MahasiswaHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtNama: TextView
        lateinit var txtEmail: TextView
        lateinit var txtAlamat: TextView
        lateinit var txtId: TextView
        lateinit var txtFoto: TextView
        fun bindMahasiswa(mahasiswa: MahasiswaResponse?) {
            itemView.apply {
                txtId = findViewById(R.id.id_mhs)
                txtNama = findViewById(R.id.nama_mhs)
                txtEmail = findViewById(R.id.email_mhs)
                txtAlamat = findViewById(R.id.alamat_mhs)
                txtFoto = findViewById(R.id.foto_mhs)

                txtId = findViewById(R.id.id_mhs)
                txtNama.text = mahasiswa?.nama
                txtEmail.text = mahasiswa?.email
                txtAlamat.text = mahasiswa?.alamat
                txtFoto.text = mahasiswa?.foto
            }
        }
    }

    override fun getItemCount(): Int {
        return mahasiswa?.size ?: 0
    }
}

