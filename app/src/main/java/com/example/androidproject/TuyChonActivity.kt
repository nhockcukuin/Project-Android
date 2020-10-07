package com.example.ebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class TuyChonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuychon)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.nav_tuychon

        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(
                        Intent(
                            applicationContext, HomeActivity::class.java
                        )
                    )
                    overridePendingTransition(0, 0)
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

    fun btnthongtin(v: View?){
        val intent = Intent(this,ThongTinActivity::class.java)
        startActivity(intent)
    }
    fun btnyeuthich(v: View?){
        val intent = Intent(this,YeuthichActivity::class.java)
        startActivity(intent)
    }
    fun btndx(v: View?){
        val intent = Intent(this,DangNhapActivity::class.java)
        startActivity(intent)
    }
    fun btnthoat(v: View?){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}