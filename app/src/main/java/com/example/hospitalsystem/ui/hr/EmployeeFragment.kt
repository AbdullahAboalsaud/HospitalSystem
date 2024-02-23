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
import com.example.hospitalsystem.databinding.FragmentEmployeeBinding
import com.example.hospitalsystem.utils.ALL
import com.example.hospitalsystem.utils.ANALYSIS
import com.example.hospitalsystem.utils.DOCTOR
import com.example.hospitalsystem.utils.HR
import com.example.hospitalsystem.utils.MANAGER
import com.example.hospitalsystem.utils.NURSE
import com.example.hospitalsystem.utils.RECEPTIONIST


class EmployeeFragment : Fragment() {
    private var _binding: FragmentEmployeeBinding? = null
    private val binding get() = _binding!!

    private val typesAdapter by lazy { AdapterRecyclerTypes() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEmployeeBinding.bind(view)

        var typesList = ArrayList<ModelCategory>()

        typesList.add(ModelCategory(ALL))
        typesList.add(ModelCategory(DOCTOR))
        typesList.add(ModelCategory(HR))
        typesList.add(ModelCategory(NURSE))
        typesList.add(ModelCategory(RECEPTIONIST))
        typesList.add(ModelCategory(MANAGER))
        typesList.add(ModelCategory(ANALYSIS))

        typesAdapter.differ.submitList(typesList)
        binding.recyclerTabs.adapter=typesAdapter

        binding.recyclerEmployees.setOnClickListener {
            findNavController().navigate(
                EmployeeFragmentDirections.actionEmployeeFragmentToProfileFragment()
            )
        }
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(
                EmployeeFragmentDirections.actionEmployeeFragmentToUserFragment()
            )
        }
        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }


}