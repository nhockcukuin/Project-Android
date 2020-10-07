package com.example.ebook

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.model.Chuong

class ChuongActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuong)

        val value: Int = intent.getIntExtra("key", -1)

        val myrv = findViewById(R.id.recycler_chuong) as RecyclerView
        val myAdapter = AdapterChuong(this, getData())
        myrv.layoutManager = LinearLayoutManager(this)
        myrv.adapter = myAdapter
    }

    private fun getData(): ArrayList<Chuong> {
        var arrayList = ArrayList<Chuong>()

        arrayList.add(Chuong( "Chuong 1"))
        arrayList.add(Chuong( "Chuong 2"))
        arrayList.add(Chuong("Chương 3"))
        arrayList.add(Chuong( "Chương 4"))

        return arrayList

    }
}