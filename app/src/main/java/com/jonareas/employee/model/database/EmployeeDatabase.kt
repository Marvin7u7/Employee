package com.jonareas.employee.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jonareas.employee.model.dao.EmployeeDao
import com.jonareas.employee.model.database.EmployeeDatabase.Companion.DATABASE_VERSION
import com.jonareas.employee.model.entities.Employee
import java.security.AccessControlContext


@Database(entities = [Employee::class], version = DATABASE_VERSION)
abstract class EmployeeDatabase : RoomDatabase(){

    abstract fun employeeDao() : EmployeeDao

    companion object{

        internal const val  DATABASE_VERSION = 1
        private  const val DATABASE_NAME = "employee.db"

        @Volatile
        private var INSTANCE : EmployeeDatabase? = null
        private fun buildDatabase(contex : Context) : EmployeeDatabase =
            Room.databaseBuilder(contex, EmployeeDatabase::class.java, "Employee")
                .fallbackToDestructiveMigration()
                .build()


        fun getIntance(contex: Context) : EmployeeDatabase =
            INSTANCE ?: synchronized(this){
                buildDatabase(contex)
            }.also { INSTANCE = it }
    }
}