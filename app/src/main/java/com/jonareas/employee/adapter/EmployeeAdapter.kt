package com.jonareas.employee.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.jonareas.employee.databinding.ListItemEmployeeBinding
import com.jonareas.employee.model.entities.Employee



class EmployeeAdapter(private  val clic : (Employee)->Unit) : ListAdapter<Employee, EmployeeAdapter.EmployerViewHolder>(DiffCallback) {


    inner class  EmployerViewHolder(private val binding: ListItemEmployeeBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(employee: Employee) : Unit = binding.run {
        tvWorkposition.text = employee.workPosition
        namelist.text = employee.fullName
        salarylist.text = employee.salary.toString()
        root.setOnClickListener{clic}
    }

    }

    object DiffCallback : DiffUtil.ItemCallback<Employee>(){
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean =
            oldItem.employeeId == newItem.employeeId

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployerViewHolder =
        ListItemEmployeeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let { EmployerViewHolder(it) }

    override fun onBindViewHolder(holder: EmployerViewHolder, position: Int) : Unit
    = holder.bind(currentList[position])




}