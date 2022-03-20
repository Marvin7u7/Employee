package com.jonareas.employee

import android.app.Application
import com.jonareas.employee.model.database.EmployeeDatabase

class EmployeeApplication : Application() {

    companion object{

        lateinit var  INTANCE : EmployeeApplication private set
        val database : EmployeeDatabase by lazy {
            EmployeeDatabase.getIntance(INTANCE)
        }
    }

    override fun onCreate() {
        super.onCreate()
        INTANCE = this
    }
}