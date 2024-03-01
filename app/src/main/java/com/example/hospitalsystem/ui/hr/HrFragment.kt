package com.example.hospitalsystem.ui.hr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitalsystem.R
import com.example.hospitalsystem.databinding.FragmentHrBinding

class HrFragment:Fragment() {

    private var _binding: FragmentHrBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHrBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgUser.setOnClickListener {
            findNavController().navigate(
                HrFragmentDirections.actionHrFragmentToProfileFragment()
            )
        }

        binding.btnEmployee.setOnClickListener {
            findNavController().navigate(
                HrFragmentDirections.actionHrFragmentToEmployeeFragment()
            )
        }


    }

}