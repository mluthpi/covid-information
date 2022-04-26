package com.example.covidinformation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covidinformation.R
import com.example.covidinformation.databinding.ActivityProvinceBinding
import com.example.covidinformation.model.Province
import com.example.covidinformation.model.ProvinceResponse
import java.text.NumberFormat
import java.util.*

class ProvinceAdapter(private val list: List<Province>):
    RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvPositive: TextView = itemView.findViewById(R.id.tvPositive)
        val tvRecover: TextView = itemView.findViewById(R.id.tvRecover)
        val tvDeath: TextView = itemView.findViewById(R.id.tvDeath)

        fun bind(province: Province){
            with(itemView){
                tvName.text = province.province
                tvPositive.text = NumberFormat.getNumberInstance(Locale.US).format(province.positive).replace(",",".")
                tvRecover.text = NumberFormat.getNumberInstance(Locale.US).format(province.recover).replace(",",".")
                tvDeath.text = NumberFormat.getNumberInstance(Locale.US).format(province.death).replace(",",".")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(list[position])

    }



    override fun getItemCount(): Int = list.size



}

