package com.jonareas.employee.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonareas.employee.EmployeeApplication
import com.jonareas.employee.model.entities.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EmployeeListViewModel : ViewModel() {


    val listEmployee: MutableLiveData<List<Employee>> =
        MutableLiveData()

    val employeeDao = EmployeeApplication.database.employeeDao()

    fun getEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            employeeDao.getAll().collect {
                listEmployee.value = it
            }
        }
    }

}