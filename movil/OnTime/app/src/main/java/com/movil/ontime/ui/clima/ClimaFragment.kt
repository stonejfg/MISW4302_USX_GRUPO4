package com.movil.ontime.ui.clima

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.movil.ontime.databinding.FragmentClimaBinding

class ClimaFragment : Fragment() {

    private var _binding: FragmentClimaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val climaViewModel =
            ViewModelProvider(this).get(ClimaViewModel::class.java)

        _binding = FragmentClimaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textTituloFragmentClima
        climaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClimaContinuar.setOnClickListener {
            val action = ClimaFragmentDirections.actionNavigationFragmentClimaToFloatingAddButton()
            binding.root.findNavController().navigate(action)


        }
    }


     override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
     }

}