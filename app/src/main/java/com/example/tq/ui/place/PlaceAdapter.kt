package com.example.tq.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.tq.R
import com.example.tq.logic.model.Place
import kotlinx.android.synthetic.main.place_item.view.*

class PlaceAdapter(private val fragment:Fragment,private val PlaceList:List<Place>):RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    inner class PlaceHolder(view:View):RecyclerView.ViewHolder(view){
        val placeName:TextView = view.findViewById(R.id.placeName)
        val placeAddress:TextView  = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val viewContent = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)

        return PlaceHolder(viewContent)
    }

    override fun getItemCount()=PlaceList.size

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.placeAddress.text = PlaceList.get(position).lat
        holder.placeName.text = PlaceList.get(position).name
    }
}