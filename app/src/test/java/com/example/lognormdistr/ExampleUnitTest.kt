package com.example.lognormdistr

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkCorrectInput() {
        assertEquals("1,2", InputHandler.handle(
            "1", "2",
            fun (str1, str2): String { return "$str1,$str2" },
            fun (errorMsg: String): String { return errorMsg }
        ))
        assertEquals("1.5,2.5", InputHandler.handle(
            "1.5", "2.5",
            fun (str1, str2): String { return "$str1,$str2" },
            fun (errorMsg: String): String { return errorMsg }
        ))
    }

    @Test
    fun checkEmptyInput() {
        assertEquals(InputHandler.emptyInputMsg, InputHandler.handle(
            "", "",
            fun (_, _): String { return "Success" },
            fun (errorMsg: String): String { return errorMsg }
        ))
        assertEquals(InputHandler.emptyInputMsg, InputHandler.handle(
            "1", "",
            fun (_, _): String { return "Success" },
            fun (errorMsg: String): String { return errorMsg }
        ))
        assertEquals(InputHandler.emptyInputMsg, InputHandler.handle(
            "", "2",
            fun (_, _): String { return "Success" },
            fun (errorMsg: String): String { return errorMsg }
        ))
    }

    @Test
    fun checkNonNumericInput() {
        assertEquals(InputHandler.nonNumericInputMsg, InputHandler.handle(
            "a", "b",
            fun (_, _): String { return "Success" },
            fun (errorMsg: String): String { return errorMsg }
        ))
        assertEquals(InputHandler.nonNumericInputMsg, InputHandler.handle(
            "a", "2",
            fun (_, _): String { return "Success" },
            fun (errorMsg: String): String { return errorMsg }
        ))
        assertEquals(InputHandler.nonNumericInputMsg, InputHandler.handle(
            "1", "b",
            fun (_, _): String { return "Success" },
            fun (errorMsg: String): String { return errorMsg }
        ))
    }

    @Test
    fun checkGeneration() {
        assertNotNull(
            LognormalDistribution.generate(0.0, 1.0)
                .toString().toDoubleOrNull()
        )
    }

    @Test
    fun checkGenerationRandomness() {
        val mu = 0.0
        val sigma = 1.0
        val res1 = LognormalDistribution.generate(mu, sigma)
        val res2 = LognormalDistribution.generate(mu, sigma)
        val res3 = LognormalDistribution.generate(mu, sigma)
        assertNotEquals(res1, res2)
        assertNotEquals(res2, res3)
        assertNotEquals(res1, res3)
    }
}