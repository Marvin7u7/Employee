package com.jonareas.employee.model.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update
import java.io.Serializable

interface BaseDao<T : Serializable> {

    @Insert(onConflict = REPLACE)
    fun insert(entity: T)

    @Insert(onConflict = REPLACE)
    fun insert(vararg entity: T)

    @Update(onConflict = REPLACE)
    fun update(entity: T)

    @Delete
    fun delete(entity: T)

    @Delete
    fun delete(vararg entity: T)

}