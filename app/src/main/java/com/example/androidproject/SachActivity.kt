package com.example.ebook

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.controller.sach.SachController
import com.example.ebook.controller.sach.SachInterface
import com.example.ebook.model.Sach



class SachActivity : AppCompatActivity(),SachInterface {

    private var tvloai : TextView? = null
    private lateinit var bookTypeCode:String

    override fun onCreate(savedInstanceState: Bundle?) {
        SachController.getInstance(this,this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sach)

        tvloai = findViewById(R.id.txt_sach)
        bookTypeCode = intent.extras?.getString("code").toString()
    }


    override fun getSach(list: MutableList<Sach>) {

        val listQueryDataBook = SachController.getInstance(this).queryBook(bookTypeCode)

        val myrv = findViewById<RecyclerView>(R.id.recycler_sach)

        val myAdapter = AdapterSach(this, listQueryDataBook)

        myrv.layoutManager = LinearLayoutManager(this)

        myrv.adapter = myAdapter
    }
}