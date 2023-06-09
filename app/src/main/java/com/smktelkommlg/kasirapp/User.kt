package com.smktelkommlg.kasirapp

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name: String,
    var username: String,
    var password: String,
    var job: String,
    var image: Int
)