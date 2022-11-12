package io.github.lukasprediger.aoc.day1

import io.github.lukasprediger.aoc.common.readInput
import kotlin.math.floor

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Int = readInput(1).map(String::toInt).sumOf(Int::fuelRequirement)
fun part2(): Int = readInput(1).map(String::toInt).sumOf(Int::totalFuelRequirement)


val Int.fuelRequirement
    get() = floor(toFloat() / 3f).toInt() - 2

val Int.totalFuelRequirement: Int
    get() {
        var fuel = fuelRequirement
        var totalFuel = 0
        while (fuel > 0) {
            totalFuel += fuel
            fuel = fuel.fuelRequirement
        }
        return totalFuel
    }
