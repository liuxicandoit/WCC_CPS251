package com.ebookfrenzy.contacts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//This is the database

@Database(entities = [(Contact::class)], version = 1)
abstract class ContactRoomDatabase: RoomDatabase() {

    abstract fun productDao(): ContactDao

    companion object {

        private var INSTANCE: ContactRoomDatabase? = null

        internal fun getDatabase(context: Context): ContactRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder<ContactRoomDatabase>(
                                context.applicationContext,
                                ContactRoomDatabase::class.java,
                                "contact_database").build()
                        //"product_database" is name of the database
                    }
                }
            }
            return INSTANCE
        }
    }
}