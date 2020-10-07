package com.example.ebook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.model.SachYeuThich

class YeuthichActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yeuthich)

        val value: Int = intent.getIntExtra("key", -1)

        val myrv = findViewById(R.id.recycler_yeuthich) as RecyclerView
        val myAdapter = AdapterYeuThich(this, getData())
        myrv.layoutManager = LinearLayoutManager(this)
        myrv.adapter = myAdapter


    }

    private fun getData(): ArrayList<SachYeuThich> {
        var arrayList = ArrayList<SachYeuThich>()

        arrayList.add(SachYeuThich(R.drawable.loai1, "Tên sách loại 1", "bla bla bla"))
        arrayList.add(SachYeuThich(R.drawable.loai1, "Tên sách loại 1", "bla bla bla"))
        arrayList.add(SachYeuThich(R.drawable.loai1, "Tên sách loại 1", "bla bla bla"))
        arrayList.add(SachYeuThich(R.drawable.loai1, "Tên sách loại 1", "bla bla bla"))

        return arrayList

    }

}