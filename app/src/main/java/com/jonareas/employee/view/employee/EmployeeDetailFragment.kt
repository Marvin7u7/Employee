package com.jonareas.employee.view.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jonareas.employee.R
import com.jonareas.employee.databinding.FragmentEmployeeDetailBinding


class EmployeeDetailFragment : Fragment() {


    private var _binding : FragmentEmployeeDetailBinding? = null
    private val binding : FragmentEmployeeDetailBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmployeeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        binding.buttonAdd.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.buttonDelete.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}