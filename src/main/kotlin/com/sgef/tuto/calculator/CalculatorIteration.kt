package com.sgef.tuto.calculator

fun addIteration(numbers: String): Int {
    return if (numbers.isEmpty()) {
        0
    } else if (hasCustomDelimiter(numbers)) {
        val (_, numbers1) = parseNext(numbers, CUSTOM_DELIMITER.length)
        val (delimiter, numbers2) = parseNext(numbers1)
        calculate(numbers2, delimiter)
    } else {
        calculate(numbers)
    }
}

private fun parseNext(numbers: String, length: Int = 1): Pair<String, String> {
    val value = numbers.substring(0, length)
    val nextNumbers = numbers.substring(length)
    return Pair(value, nextNumbers)
}

private fun hasCustomDelimiter(numbers: String): Boolean = numbers.startsWith(CUSTOM_DELIMITER)

private fun calculate(numbers: String, delimiter: String = ","): Int = numbers
        .split(delimiter, "\\n")
        .map { if (it.isEmpty()) 0 else it.toInt() }
        .sum()
