package com.example.ebook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.controller.TimKiem.TimKiemController
import com.example.ebook.model.TimKiem


class AdapterTK(private val mContext: TimKiemActivity,var mData: MutableList<TimKiem>) :
    RecyclerView.Adapter<AdapterTK.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.item_timkiem, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.img_sach.setImageResource(mData[position].anhsach)
        holder.tv_tensach.setText(mData[position].tensach)
        holder.tv_ttnd.setText(mData[position].tacgia)
        holder.cardView.setOnClickListener {
            val intent = Intent(mContext,SachActivity::class.java)
            intent.putExtra("content", TimKiemController.instances.getSachCode(position))
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_sach: ImageView
        var tv_tensach: TextView
        var tv_ttnd: TextView
        var cardView: CardView

        init {
            img_sach = itemView.findViewById<View>(R.id.img_sach) as ImageView
            tv_tensach = itemView.findViewById<View>(R.id.txt_tensach) as TextView
            tv_ttnd = itemView.findViewById<View>(R.id.txt_tacgia) as TextView
            cardView = itemView.findViewById<View>(R.id.card_tk_id) as CardView
        }
    }

}