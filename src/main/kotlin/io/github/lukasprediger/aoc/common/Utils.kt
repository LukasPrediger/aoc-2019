package io.github.lukasprediger.aoc.common

import java.io.File
import java.lang.IllegalArgumentException

fun readInput(day: Int): List<String> {
    val fileName = "/day$day.txt"
    val inputUrl = object{}::class.java.getResource(fileName) ?: throw IllegalArgumentException("Can't find $fileName")
    return File(inputUrl.toURI()).readLines()
}