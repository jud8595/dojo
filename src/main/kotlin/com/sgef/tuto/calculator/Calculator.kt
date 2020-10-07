package com.sgef.tuto.calculator

import java.util.regex.Pattern

const val CUSTOM_DELIMITER = "//"

fun add(numbers: String): Int {
    if (numbers.isEmpty()) {
        return 0
    }
    val compile = Pattern.compile("$CUSTOM_DELIMITER(.)(.+)")
    val matcher = compile.matcher(numbers)
    return if (matcher.matches()) {
        calculate(matcher.group(2), matcher.group(1))
    } else {
        calculate(numbers)
    }
}

private fun calculate(numbers: String, delimiter: String = ","): Int = numbers
        .split(delimiter, "\\n")
        .map { if (it.isEmpty()) 0 else it.toInt() }
        .sum()
