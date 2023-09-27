package com.movil.ontime.ui.TimePciker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.movil.ontime.databinding.FragmentDatePickerBinding
import java.time.LocalDateTime

class TimePickerFragment : Fragment() {

    private var _binding:  FragmentDatePickerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var selectedHour: Int? = null
    private var selectedMinute: Int? = null
    lateinit var picker: MaterialTimePicker
    var estadoClima: Boolean? = false
    var movilidad: Boolean? = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val timePickerViewModel =
            ViewModelProvider(this).get(TimePickerViewModel::class.java)

        _binding = FragmentDatePickerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val hour = selectedHour ?: LocalDateTime.now().hour
        val minute = selectedMinute ?: LocalDateTime.now().minute

        picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(10)
                .setTitleText("Seleccione Tiempo")
                .build()
                .apply {
                    addOnPositiveButtonClickListener { onTimeSelected(this.hour, this.minute) }
                }

        picker.show(childFragmentManager, "tag");

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // To listen for a switch's checked/unchecked state changes
        binding.checkNoticias.setOnCheckedChangeListener {buttonView, isChecked ->
            // Responds to switch being checked/unchecked
            if (isChecked){
                MaterialAlertDialogBuilder(this.requireContext())
                    .setTitle("Éxito!")
                    .setMessage("Tu alarma ha sido cofigurada éxitosamente!")
                    .setPositiveButton("Ok") { dialog, which ->
                        // Respond to positive button press
                    }
                    .show()
            }
        }

        // To listen for a switch's checked/unchecked state changes
        binding.checkIndicadores.setOnCheckedChangeListener {buttonView, isChecked ->
            // Responds to switch being checked/unchecked
            if (isChecked){
            MaterialAlertDialogBuilder(this.requireContext())
                .setTitle("Éxito!")
                .setMessage("Tu alarma ha sido cofigurada éxitosamente!")
                .setPositiveButton("Ok") { dialog, which ->
                    // Respond to positive button press
                }
                .show()
            }
        }

        // To listen for a switch's checked/unchecked state changes
        binding.checkEstadoClima.setOnCheckedChangeListener {buttonView, isChecked ->
            // Responds to switch being checked/unchecked
            if (isChecked){
                estadoClima = true
            }
        }

        // To listen for a switch's checked/unchecked state changes
        binding.checkMovilidad.setOnCheckedChangeListener {buttonView, isChecked ->
            // Responds to switch being checked/unchecked
            if (isChecked){
                movilidad = true
            }
        }



        binding.btnNotificacionContinuar.setOnClickListener {

            if(estadoClima == true){
                val action =  TimePickerFragmentDirections.actionNavigationFragmentTimePickerToNavigationFragmentClima()
                binding.root.findNavController().navigate(action)
            }else if(movilidad == true){

            }

        }
    }

    private fun onTimeSelected(hour: Int, minute: Int) {
        selectedHour = hour
        selectedMinute = minute
        val hourAsText = if (hour < 10) "0$hour" else hour
        val minuteAsText = if (minute < 10) "0$minute" else minute
        //"$hourAsText:$minuteAsText".also { binding.textTituloNotificacion.text = it}

    }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

    }