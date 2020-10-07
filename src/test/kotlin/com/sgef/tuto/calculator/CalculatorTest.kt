package com.sgef.tuto.calculator

import org.junit.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun `should add numbers for empty string`() {
        assertEquals(0, add(""))
    }

    @Test
    fun `should return sum for one number string`() {
        assertEquals(0, add("0"))
        assertEquals(1, add("1"))
    }

    @Test
    fun `should return sum for 2 numbers string`() {
        assertEquals(3, add("1,2"))
        assertEquals(4, add("2,2"))
    }

    @Test
    fun `should return sum for more than 2 numbers string`() {
        assertEquals(6, add("1,2,3"))
        assertEquals(14, add("2,2,10"))
    }

    @Test
    fun `should handle new lines between numbers`() {
        assertEquals(6, add("1\\n2,3"))
    }

    @Test
    fun `should support different delimiters`() {
        assertEquals(3, add("//;\\n1;2"))
    }

}