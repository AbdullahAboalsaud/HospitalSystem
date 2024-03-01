package com.example.hospitalsystem.ui.hr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitalsystem.adapters.AdapterRecyclerTypes
import com.example.hospitalsystem.data.ModelCategory
import com.example.hospitalsystem.databinding.FragmentEmployeeListBinding
import com.example.hospitalsystem.utils.ALL
import com.example.hospitalsystem.utils.ANALYSIS
import com.example.hospitalsystem.utils.DOCTOR
import com.example.hospitalsystem.utils.HR
import com.example.hospitalsystem.utils.MANAGER
import com.example.hospitalsystem.utils.NURSE
import com.example.hospitalsystem.utils.RECEPTIONIST


class EmployeeListFragment : Fragment() {
    private var _binding: FragmentEmployeeListBinding? = null
    private val binding get() = _binding!!
    private var typesList = ArrayList<ModelCategory>()

    private val typesAdapter by lazy { AdapterRecyclerTypes() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        importTypesList()
        typesAdapter.differ.submitList(typesList)
        binding.recyclerTabs.adapter=typesAdapter

        observe()

        navigation()




    }

    private fun observe() {

    }

    private fun navigation(){
        binding.recyclerEmployees.setOnClickListener {
            findNavController().navigate(
                EmployeeListFragmentDirections.actionEmployeeFragmentToProfileFragment()
            )
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(
                EmployeeListFragmentDirections.actionEmployeeFragmentToUserFragment()
            )
        }

        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    private fun importTypesList(){
        typesList.add(ModelCategory(ALL))
        typesList.add(ModelCategory(DOCTOR))
        typesList.add(ModelCategory(HR))
        typesList.add(ModelCategory(NURSE))
        typesList.add(ModelCategory(RECEPTIONIST))
        typesList.add(ModelCategory(MANAGER))
        typesList.add(ModelCategory(ANALYSIS))
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}