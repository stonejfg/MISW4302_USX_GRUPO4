package com.movil.ontime.ui.home

import android.R
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.movil.ontime.databinding.FragmentListarBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentListarBinding? = null
    lateinit var addFAB: FloatingActionButton
    private lateinit var viewModel: HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentListarBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingAddButton.setOnClickListener {
            val action =  HomeFragmentDirections.actionHomeToFragmetDatePicker()
            binding.root.findNavController().navigate(action)
        }
    }

        override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}