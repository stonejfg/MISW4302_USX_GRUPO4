package com.movil.ontime.ui.mapas.destino

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.movil.ontime.databinding.FragmentMapasDestinoBinding
import com.movil.ontime.databinding.FragmentMapasOrigenBinding
import com.movil.ontime.ui.clima.MapasOrigenViewModel
import com.movil.ontime.ui.mapas.MapasOrigenFragmentDirections

class MapasDestinoFragment : Fragment() {

    private var _binding: FragmentMapasDestinoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mapasDestinoViewModel =
            ViewModelProvider(this).get(MapasDestinoViewModel::class.java)

        _binding = FragmentMapasDestinoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textTituloFragmentOrigenMapas
        mapasOrigenViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMapasDestinoContinuar.setOnClickListener {
            val action = MapasDestinoFragmentDirections.actionNavigationMapasDestinoToNavigationMapsDestino()
            binding.root.findNavController().navigate(action)


        }
    }

     override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
     }

}