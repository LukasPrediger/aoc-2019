package io.github.lukasprediger.aoc.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day1Test {

    @ParameterizedTest
    @CsvSource(value = ["12,2", "14,2", "1969,654", "100756,33583"])
    fun `Fuel consumption should match expected value`(mass: Int, fuel: Int) {
        mass.fuelRequirement shouldBe fuel
    }

    @ParameterizedTest
    @CsvSource(value = ["14,2", "1969,966", "100756,50346"])
    fun `Fuel consumption should match expected value with fuel mass`(mass: Int, fuel: Int) {
        mass.totalFuelRequirement shouldBe fuel
    }

    private infix fun Any.shouldBe(other: Any) = assertEquals(other, this)
}