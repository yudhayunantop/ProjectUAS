package com.dicoding.picodiploma.ProjectUAS.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//deklarasi objek dan dataBase yang memanfaatkan room
@Entity(tableName = "order_table")
data class food(
    @PrimaryKey(autoGenerate = true) var foodId: Int = 0,
    @ColumnInfo(name = "username") var username: String = "",
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "price") var price: Int = 0,
    @ColumnInfo(name = "quantity") var quantity: Int = 0,
    @ColumnInfo(name = "photo") var photo: Int = 0,
    var detail: String = ""
)

// Migration from 1 to 2, Room 2.1.0
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE food ADD COLUMN username TEXT DEFAULT ''")
    }
}

// Migration from 2 to 3, Room 2.1.0
val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE food ADD COLUMN foodId INT DEFAULT 0 NOT NULL PRIMARY KEY")
    }
}


