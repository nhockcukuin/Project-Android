package com.example.ebook
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.controller.loaisach.LoaiSachController
import com.example.ebook.controller.loaisach.LoaiSachInterface
import com.example.ebook.model.LoaiSach
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity: AppCompatActivity(),LoaiSachInterface {

    lateinit var listBookType:MutableList<LoaiSach>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        LoaiSachController.getInstance(this,this)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.nav_home

        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_timkiem -> {
                    startActivity(
                        Intent(
                            applicationContext, TimKiemActivity::class.java
                        )
                    )
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_tuychon -> {
                    startActivity(
                        Intent(
                            applicationContext, TuyChonActivity::class.java
                        )
                    )
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    override fun getListSach(list: MutableList<LoaiSach>) {
        listBookType = list
        val myrv = findViewById<RecyclerView>(R.id.recycler_loaisach)
        val myAdapter = AdapterLoaiSach(this, listBookType)
        myrv.layoutManager = GridLayoutManager(this, 2)
        myrv.adapter = myAdapter
    }
}