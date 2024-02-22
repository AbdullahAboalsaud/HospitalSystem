package com.example.hospitalsystem.ui.hr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitalsystem.R
import com.example.hospitalsystem.adapters.AdapterRecyclerTypes
import com.example.hospitalsystem.data.ModelCategory
import com.example.hospitalsystem.databinding.FragmentUserBinding
import com.example.hospitalsystem.utils.Const


class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}