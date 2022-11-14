package io.github.lukasprediger.aoc.day2

import io.github.lukasprediger.aoc.common.shouldBe
import org.junit.jupiter.api.Test

internal class InterpreterTest {

    @Test
    fun `Simple Example`() {
        val initialState = listOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50)
        Interpreter(initialState).run() shouldBe 3500
    }
}