package com.jonareas.employee.view.employee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jonareas.employee.R
import com.jonareas.employee.databinding.FragmentEmployeeListBinding

class EmployeeListFragment : Fragment() {

    private var _binding : FragmentEmployeeListBinding? = null
    private val binding : FragmentEmployeeListBinding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        binding.fabAddemployee.setOnClickListener{
        findNavController().navigate(EmployeeListFragmentDirections.actionListToAddemployee())
        }

    }

}