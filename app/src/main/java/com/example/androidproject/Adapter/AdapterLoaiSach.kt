package com.example.ebook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.controller.loaisach.LoaiSachController
import com.example.ebook.model.LoaiSach


class AdapterLoaiSach(private val mContext: HomeActivity, private val mData: MutableList<LoaiSach>) :
    RecyclerView.Adapter<AdapterLoaiSach.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.item_loaisach, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_loaisach.text = mData[position].tenLoaiSach
//        holder.img_sach.setImageResource(mData[position].gethinh())
        holder.cardView.setOnClickListener {
            val intent = Intent(mContext,SachActivity::class.java)
            intent.putExtra("code", LoaiSachController.instances.getBookCode(position))
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_sach: ImageView = itemView.findViewById<ImageView>(R.id.img_loaisach)
        var tv_loaisach: TextView
        var cardView: CardView
        init {
            tv_loaisach = itemView.findViewById<View>(R.id.txt_loaisach) as TextView
            cardView = itemView.findViewById<View>(R.id.card_id) as CardView
        }
    }

}