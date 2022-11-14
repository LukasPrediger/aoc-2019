package io.github.lukasprediger.aoc.common

import org.junit.jupiter.api.Assertions

infix fun Any.shouldBe(other: Any) = Assertions.assertEquals(other, this)
