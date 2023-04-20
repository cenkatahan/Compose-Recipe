package com.atahan.compose_recipe.db

fun main() {
    val list = listOf<String>("COD MWII", "BORDERLANDS", "RESIDENT EVIL", "IRACING")
    val listAsString = list.joinToString(separator = "-")
    println("List to string => $listAsString")

    val splitList = listAsString.split('-')
    println("Trimmed string => $splitList")
}