package com.dicoding.picodiploma.ProjectUAS.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//deklarasi objek dan dataBase yang memanfaatkan room
@Entity(tableName = "order_table")
data class food(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "price") var price: Int = 0,
    @ColumnInfo(name = "quantity") var quantity: Int = 0,
    @ColumnInfo(name = "photo") var photo: Int = 0,
    var detail: String = ""
)