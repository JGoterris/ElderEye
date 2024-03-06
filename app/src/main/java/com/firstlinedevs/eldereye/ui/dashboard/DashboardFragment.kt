package com.firstlinedevs.eldereye.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstlinedevs.eldereye.R
import com.firstlinedevs.eldereye.databinding.FragmentDashboardBinding
import com.firstlinedevs.eldereye.recyclerpackage.CameraProvider
import com.firstlinedevs.eldereye.recyclerpackage.adapter.CameraAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        dashboardViewModel.text.observe(viewLifecycleOwner) {

        }
        initRecyclerView()
        return root
    }

    private fun initRecyclerView(){
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.recyclerCameras)
        recyclerView?.layoutManager = LinearLayoutManager(context?.applicationContext)
        recyclerView?.adapter = CameraAdapter(CameraProvider.cameraList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}