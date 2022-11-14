package io.github.lukasprediger.aoc.day2

import io.github.lukasprediger.aoc.common.readCsv

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Int {
    return runInterpreter(12, 2)
}

fun part2(): Int {
    val verbNouns = buildList {
        for (verb in 0..99) {
            for (noun in 0..99) {
                add(verb to noun)
            }
        }
    }


    for ((verb, noun) in verbNouns) {
        val result = runInterpreter(verb, noun)
        if (result == 19690720) {
            return 100 * verb + noun
        }
    }
    throw IllegalStateException("Could not find any combinations")
}

private fun runInterpreter(verb: Int, noun: Int): Int {
    val state = readCsv(2).first().map { it.toInt() }.toMutableList()
    state[1] = verb
    state[2] = noun

    return Interpreter(state).run()
}

class Interpreter(
    initialState: List<Int>
) {
    private val state: MutableList<Int> = initialState.toMutableList()

    private var currentPosition: Int = 0
    private fun peek(offset: Int) = state[currentPosition + offset]

    private val current
        get() = peek(0)

    private fun nextOperation() {
        currentPosition += 4
    }

    fun run(): Int {
        while (true) {
            when (current) {
                1 -> add()
                2 -> multiply()
                99 -> break
                else -> throw IllegalStateException("Opcode $current is unknown")
            }
            nextOperation()
        }

        return state[0]
    }

    private fun add() {
        val first = state[peek(1)]
        val second = state[peek(2)]

        state[peek(3)] = first + second
    }

    private fun multiply() {
        val first = state[peek(1)]
        val second = state[peek(2)]

        state[peek(3)] = first * second
    }
}