package com.smktelkommlg.kasirapp

@Entity
data class Meja(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var number : Int
)