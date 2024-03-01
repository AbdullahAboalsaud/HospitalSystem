package com.example.hospitalsystem.ui.hr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitalsystem.R
import com.example.hospitalsystem.databinding.FragmentNewUserBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class NewUserFragment : Fragment() {

    private var _binding: FragmentNewUserBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewUserBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            editDateOfBirth.setOnClickListener {
                val datePicker =
                    MaterialDatePicker.Builder.datePicker()
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .setTheme(R.style.Base_Theme_HospitalSystem)
                        .build()

                datePicker.show(parentFragmentManager,"material date picker")
                datePicker.addOnPositiveButtonClickListener {
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    editDateOfBirth.setText(dateFormat.format(Date(it).time))
                }
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}