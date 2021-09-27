package com.example.cloudy.source.db.country

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "countries")
data class CountryDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "iso_2")
    val iso2: String = "",
    @ColumnInfo(name = "iso_3")
    val iso3: String = ""
)
