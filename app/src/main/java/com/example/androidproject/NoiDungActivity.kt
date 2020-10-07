package com.example.ebook

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.controller.noidung.NoiDungController
import com.example.ebook.controller.noidung.NoiDungInterface
import com.example.ebook.model.Noidung

class NoiDungActivity : AppCompatActivity(),NoiDungInterface {
    private var tvnd : TextView? = null
    private lateinit var bookContentCode:String
    override fun onCreate(savedInstanceState: Bundle?) {
        NoiDungController.getInstance(this,this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noidung)
        bookContentCode = intent.extras?.getString("content").toString()
    }


    override fun getNoiDung(list: MutableList<Noidung>) {
        val listDataBook = NoiDungController.getInstance(this).queryND(bookContentCode)

        val myrv = findViewById<RecyclerView>(R.id.recycler_nd)

        val myAdapter = AdapterND(this, listDataBook)

        myrv.layoutManager = LinearLayoutManager(this)

        myrv.adapter = myAdapter
    }
}