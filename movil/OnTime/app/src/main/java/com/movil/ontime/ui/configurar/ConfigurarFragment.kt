package com.movil.ontime.ui.configurar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.movil.ontime.databinding.FragmentConfigurarBinding

class ConfigurarFragment : Fragment() {

    private var _binding: FragmentConfigurarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val configurarViewModel =
            ViewModelProvider(this).get(ConfigurarViewModel::class.java)

        _binding = FragmentConfigurarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfiguracionGuardar.setOnClickListener {

            MaterialAlertDialogBuilder(this.requireContext())
                .setTitle("Éxito!")
                .setMessage("Sus configuraciones se ha actualizado! ")
                .setPositiveButton("Ok") { dialog, which ->
                    // Respond to positive button press
                }
                .show()

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}