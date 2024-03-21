package com.firstlinedevs.eldereye.recyclerpackage.adapter

import android.app.Dialog
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.firstlinedevs.eldereye.CocinaActivity
import com.firstlinedevs.eldereye.R
import com.firstlinedevs.eldereye.recyclerpackage.CameraData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView

class CameraViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    val ivPhoto = view.findViewById<ShapeableImageView>(R.id.ivPhoto)
    val tvCameraName = view.findViewById<TextView>(R.id.tvCameraName)
    val ivStart = view.findViewById<ImageView>(R.id.ivStart)

    fun render(cameraModel: CameraData){
        tvCameraName.text = cameraModel.name
        ivPhoto.setImageResource(cameraModel.photo.toInt())
        ivStart.setOnClickListener{
            if(tvCameraName.text.equals("Cocina")){
                view.context.startActivity(Intent(view.context,CocinaActivity::class.java))
            } else{
                dialogoNoEjemplo()
            }
        }
    }

    fun dialogoNoEjemplo() {
        val algoritmoDialog = AlertDialog.Builder(view.context)
        algoritmoDialog.setTitle("Sin ejemplo")
        algoritmoDialog.setMessage("Para ver un ejemplo del funcionamiento de las cámaras con nuestra IA, seleccionar la cámara Cocina.")
        algoritmoDialog.setPositiveButton(android.R.string.yes) { dialog, which ->}
        algoritmoDialog.show()
    }
}