package com.jonareas.employee.model.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idEmployee")
    val employeeId : Long
    ,@NotNull val fullName : String
    ,@NotNull val workPosition: String
    ,@NotNull  private val baseSalary : Double
    ): Serializable{

    val salary : Double
    get() =
        when {
            baseSalary < 0 ->   0.0
            baseSalary < 5000 -> baseSalary * 0.20 * baseSalary
            baseSalary < 1000 -> baseSalary * 0.15 * baseSalary
            else -> baseSalary * 0.10 * baseSalary
        }

}
