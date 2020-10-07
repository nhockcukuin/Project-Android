package com.example.ebook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.model.Chuong


class AdapterChuong(private val mContext: ChuongActivity, mData: List<Chuong>) :
    RecyclerView.Adapter<AdapterChuong.MyViewHolder>() {
    private val mData: List<Chuong>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.item_chuong, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tv_chuong.setText(mData[position].getchuong())
        holder.cardView.setOnClickListener {
            val intent = Intent(mContext, NoiDungActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_chuong: TextView
        var cardView: CardView

        init {

            tv_chuong = itemView.findViewById<View>(R.id.txt_chuong) as TextView
            cardView = itemView.findViewById<View>(R.id.card_id_chuong) as CardView
        }
    }

    init {
        this.mData = mData
    }

}