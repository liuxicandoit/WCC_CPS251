package com.ebookfrenzy.contacts

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allProducts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =  ContactRoomDatabase.getDatabase(application)
        contactDao = db?.productDao()
        allProducts = contactDao?.getAllProducts()
    }

    fun insertProduct(newproduct: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newproduct)
        }
    }

    private suspend fun asyncInsert(contact: Contact) {
        contactDao?.insertProduct(contact)
    }

    fun deleteProduct(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(name)
        }
    }

    private suspend fun asyncDelete(name: String) {
        contactDao?.deleteProduct(name)
    }

    fun findProduct(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()// wait for the data get returned
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findProduct(name)
        }

}