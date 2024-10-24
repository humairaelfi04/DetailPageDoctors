package com.humaira.klinikapp_mi2c.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.humaira.klinikapp_mi2c.R
import com.humaira.klinikapp_mi2c.adapter.ListDoctorsAdapter
import com.humaira.klinikapp_mi2c.model.ModelListDoctors

class HomeDoctorsActivity : AppCompatActivity() {

    private var rv_list_doctors : RecyclerView? = null
    private var homeDoctorsAdapter : ListDoctorsAdapter? = null

    //array data doctors
    private var doctorList = mutableListOf<ModelListDoctors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_doctors)

        rv_list_doctors = findViewById(R.id.rv_list_doctors)
        doctorList = ArrayList()
        homeDoctorsAdapter = ListDoctorsAdapter(this, doctorList);
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        rv_list_doctors!!.layoutManager = layoutManager
        rv_list_doctors!!.adapter = homeDoctorsAdapter

        //create dummy data
        prepareDataDoctors()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareDataDoctors(){
        var itemDoctors = ModelListDoctors(
            R.drawable.dokter1,
            "Humaira ELfi Putri",
            "Dentist",
            "120",
            "5.0",
            "28 March, 2023",
            "16.00"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter6,
            "Oryza Conseva",
            "Obgyn",
            "100",
            "5.0",
            "28 March, 2023",
            "16.00"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter3,
            "Felisha Hardina",
            "Dentist",
            "120",
            "5.0",
            "28 March, 2023",
            "16.00"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter4,
            "Salti Dilfani",
            "Dentist",
            "120",
            "5.0",
            "28 March, 2023",
            "16.00"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter1,
            "Calista Monica Alfi",
            "Dokter Umum",
            "120",
            "5.0",
            "28 March, 2023",
            "16.00"
        )
        doctorList.add(itemDoctors)

        homeDoctorsAdapter!!.notifyDataSetChanged()
    }
}