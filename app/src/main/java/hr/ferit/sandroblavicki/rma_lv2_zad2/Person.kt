package hr.ferit.sandroblavicki.rma_lv2_zad2

import java.io.Serializable

data class Person(
    val id: Int = 0,
    val name: String,
    val dateOfBirth: String,
    val quotes: List<String>,
    val description: String,
    val imageUrl: String
)  : Serializable