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
import com.example.hospitalsystem.utils.Const


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

        typesList.add(ModelCategory(Const.ALL))
        typesList.add(ModelCategory(Const.DOCTOR))
        typesList.add(ModelCategory(Const.HR))
        typesList.add(ModelCategory(Const.NURSE))
        typesList.add(ModelCategory(Const.RECEPTIONIST))
        typesList.add(ModelCategory(Const.MANAGER))
        typesList.add(ModelCategory(Const.ANALYSIS))

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