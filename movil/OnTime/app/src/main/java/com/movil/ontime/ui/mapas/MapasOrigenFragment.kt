package com.movil.ontime.ui.mapas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.movil.ontime.databinding.FragmentMapasOrigenBinding
import com.movil.ontime.ui.clima.ClimaFragmentDirections
import com.movil.ontime.ui.clima.MapasOrigenViewModel

class MapasOrigenFragment : Fragment() {

    private var _binding: FragmentMapasOrigenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mapasOrigenViewModel =
            ViewModelProvider(this).get(MapasOrigenViewModel::class.java)

        _binding = FragmentMapasOrigenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textTituloFragmentOrigenMapas
        mapasOrigenViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMapasOrigenContinuar.setOnClickListener {
            val action = MapasOrigenFragmentDirections.actionNavigationMapasOrigenToNavigationMaps()
            binding.root.findNavController().navigate(action)


        }
    }

     override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
     }

}