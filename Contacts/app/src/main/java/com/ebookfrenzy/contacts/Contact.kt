package com.ebookfrenzy.contacts

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// this is the table
@Entity(tableName = "contacts")
class Contact {

    //@ is annotation, used for

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0 // column id

    @ColumnInfo(name = "contactName")
    var contactName: String? = null


    var contactNum: Int = 0  //contact number can be placed here

    constructor() {}

    // the following is not needed, primary key is automatically generate

    constructor(id: Int, contactName: String, number: Int) {
        //this.id = id
        this.contactName = contactName
        this.contactNum = number
    }

    constructor(contactName: String, number: Int) {
        this.contactName = contactName
        this.contactNum = number
    }
}