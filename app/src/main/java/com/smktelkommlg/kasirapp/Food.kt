package com.smktelkommlg.kasirapp

@Entity
data class Food(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name: String,
    var description: String,
    var price: Int,
    var image: Int
)