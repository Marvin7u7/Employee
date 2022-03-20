package com.jonareas.employee.model.dao

import androidx.room.Dao
import androidx.room.Query
import com.jonareas.employee.model.entities.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao : BaseDao<Employee> {

    @Query("SELECT * FROM employee")
    fun getAll() : Flow<List<Employee>>

    @Query("SELECT * FROM employee WHERE idEmployee = :id")
    fun getById(id : Long) : Flow<Employee>
}
