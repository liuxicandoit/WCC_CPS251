package com.ebookfrenzy.contacts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// annotation tells android how to set things up
@Dao
interface ContactDao {

    @Insert
    fun insertProduct(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName = :name")
    fun findProduct(name: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactName = :name")
    fun deleteProduct(name: String)

    @Query("SELECT * FROM contacts")
    fun getAllProducts(): LiveData<List<Contact>>
}