package com.jonareas.employee.view.employee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jonareas.employee.R
import com.jonareas.employee.databinding.FragmentAddEmployeeBinding

class AddEmployeeFragment : Fragment() {

    private var _binding : FragmentAddEmployeeBinding? = null
    private val binding :  FragmentAddEmployeeBinding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddEmployeeBinding.inflate(inflater, container, false)
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
        binding.buttonCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}