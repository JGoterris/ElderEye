package com.firstlinedevs.eldereye.recyclerpackage.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firstlinedevs.eldereye.R
import com.firstlinedevs.eldereye.recyclerpackage.CameraData
import com.google.android.material.imageview.ShapeableImageView

class CameraViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val ivPhoto = view.findViewById<ShapeableImageView>(R.id.ivPhoto)
    val tvCameraName = view.findViewById<TextView>(R.id.tvCameraName)

    fun render(cameraModel: CameraData){
        tvCameraName.text = cameraModel.name
        ivPhoto.setImageResource(cameraModel.photo.toInt())
    }
}