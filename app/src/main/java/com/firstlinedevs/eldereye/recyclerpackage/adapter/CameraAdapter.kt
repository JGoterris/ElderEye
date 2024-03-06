package com.firstlinedevs.eldereye.recyclerpackage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstlinedevs.eldereye.R
import com.firstlinedevs.eldereye.recyclerpackage.CameraData

class CameraAdapter(private val cameraList:List<CameraData>) : RecyclerView.Adapter<CameraViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CameraViewHolder(layoutInflater.inflate(R.layout.item_camera, parent, false))
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        val item = cameraList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return cameraList.size
    }
}