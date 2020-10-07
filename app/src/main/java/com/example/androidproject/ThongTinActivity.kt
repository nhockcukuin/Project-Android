package com.example.ebook

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThongTinActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thongtin)

        val value: Int = intent.getIntExtra("key", -1)

    }

    fun btndmk(v:View){
        Toast.makeText(this,"Đổi mật khẩu thành công",Toast.LENGTH_SHORT).show()
    }

}