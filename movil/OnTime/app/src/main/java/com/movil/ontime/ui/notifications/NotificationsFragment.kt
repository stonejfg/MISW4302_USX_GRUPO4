package com.movil.ontime.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.movil.ontime.databinding.FragmentSincronizarBinding
import com.movil.ontime.ui.configurar.ConfigurarViewModel

class NotificationsFragment : Fragment() {

    private var _binding: FragmentSincronizarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentSincronizarBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.btnSincronizar.setOnClickListener {
            MaterialAlertDialogBuilder(this.requireContext())
                .setTitle("Éxito!")
                .setMessage("Sincronización Exitosa")
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