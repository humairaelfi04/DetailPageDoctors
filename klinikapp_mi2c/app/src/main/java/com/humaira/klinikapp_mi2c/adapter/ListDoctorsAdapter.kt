package com.humaira.klinikapp_mi2c.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.humaira.klinikapp_mi2c.R
import com.humaira.klinikapp_mi2c.model.ModelListDoctors
import com.humaira.klinikapp_mi2c.screen.HomeDoctorsActivity
import com.humaira.klinikapp_mi2c.DetailDoctors

class ListDoctorsAdapter (
    val getDetailDoctors : HomeDoctorsActivity,
    val itemDoctorsList : List<ModelListDoctors>
) : RecyclerView.Adapter<ListDoctorsAdapter.MyViewHolder>(){

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgItemDoctors : ImageView = itemView.findViewById(R.id.imgItemDoctor)
        var txtNamaDoctors : TextView = itemView.findViewById(R.id.txtNamaDoctor)
        var txtSpesDoctors : TextView = itemView.findViewById(R.id.txtSpesDoctor)
        var txtReviewDoctors : TextView = itemView.findViewById(R.id.txtReviewDoctor)
        var txtJumlahRating : TextView = itemView.findViewById(R.id.txtJumlahRating)
        val cardDoctor : CardView = itemView.findViewById(R.id.cardDoctor)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_doctor, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctorsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorsList[position]
        holder.txtNamaDoctors.text = currentItem.NamaDoctor
        holder.txtSpesDoctors.text = currentItem.SpesDoctor
        holder.txtReviewDoctors.text = currentItem.JumlahReview
        holder.txtJumlahRating.text = currentItem.JumlahRating
        holder.imgItemDoctors.setImageResource(currentItem.ImgDoctor)

        holder.cardDoctor.setOnClickListener(){
            //deklarasi intent
            val intent = Intent(getDetailDoctors, DetailDoctors::class.java)
            //put extra
            intent.putExtra("Image Doctor", itemDoctorsList[position].ImgDoctor)
            intent.putExtra("Nama Doctor", itemDoctorsList[position].NamaDoctor)
            intent.putExtra("Spes Doctor", itemDoctorsList[position].SpesDoctor)
            intent.putExtra("Jumlah Review", itemDoctorsList[position].JumlahReview)
            intent.putExtra("Jumlah Rating", itemDoctorsList[position].JumlahRating)
            intent.putExtra("Date", itemDoctorsList[position].date)
            intent.putExtra("Time", itemDoctorsList[position].time)

            //intent.putExtra("judul",itemList[position].judul)
            // start pindah ke detail
            getDetailDoctors.startActivity(intent)

            Toast.makeText(getDetailDoctors,itemDoctorsList[position].NamaDoctor, Toast.LENGTH_SHORT).show()
        }

    }
}