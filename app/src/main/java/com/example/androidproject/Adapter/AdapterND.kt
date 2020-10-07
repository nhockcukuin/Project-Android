package com.example.ebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.model.Noidung
class AdapterND(private val mContext: NoiDungActivity, var mData: MutableList<Noidung>) :
    RecyclerView.Adapter<AdapterND.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.item_ndsach, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.tv_chuong.setText(mData[position].tenNoiDung)
        holder.tv_nds.setText(mData[position].noiDung)

    }

    override fun getItemCount(): Int {
        return mData.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        var tv_tgts: TextView
        var tv_chuong: TextView
        var tv_nds: TextView
        var cardView: CardView

        init {
//            tv_tgts = itemView.findViewById<View>(R.id.txt_nd_sachtg) as TextView
            tv_chuong = itemView.findViewById<View>(R.id.txt_nd_chuong) as TextView
            tv_nds = itemView.findViewById<View>(R.id.txt_nd_sach) as TextView
            cardView = itemView.findViewById<View>(R.id.card_nd_id) as CardView
        }
    }
}