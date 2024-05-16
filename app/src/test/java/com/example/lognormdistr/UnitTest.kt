package com.example.lognormdistr

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkCorrectInput() {
        assertEquals("1,2", InputHandler.handle(
            "1", "2",
            { str1, str2 -> "$str1,$str2" },
            { errorMsg -> errorMsg }
        ))
        assertEquals("1.5,2.5", InputHandler.handle(
            "1.5", "2.5",
            { str1, str2 -> "$str1,$str2" },
            { errorMsg -> errorMsg }
        ))
    }

    @Test
    fun checkEmptyInput() {
        assertEquals(InputHandler.emptyInputMsg, InputHandler.handle(
            "", "",
            { _, _ -> "Success" },
            { errorMsg -> errorMsg }
        ))
        assertEquals(InputHandler.emptyInputMsg, InputHandler.handle(
            "1", "",
            { _, _ -> "Success" },
            { errorMsg -> errorMsg }
        ))
        assertEquals(InputHandler.emptyInputMsg, InputHandler.handle(
            "", "2",
            { _, _ -> "Success" },
            { errorMsg -> errorMsg }
        ))
    }

    @Test
    fun checkNonNumericInput() {
        assertEquals(InputHandler.nonNumericInputMsg, InputHandler.handle(
            "a", "b",
            { _, _ -> "Success" },
            { errorMsg -> errorMsg }
        ))
        assertEquals(InputHandler.nonNumericInputMsg, InputHandler.handle(
            "a", "2",
            { _, _ -> "Success" },
            { errorMsg -> errorMsg }
        ))
        assertEquals(InputHandler.nonNumericInputMsg, InputHandler.handle(
            "1", "b",
            { _, _ -> "Success" },
            { errorMsg -> errorMsg }
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

    @Test
    fun genLND() {
        var res = ""
        val mu = 0.0
        val sigma = 0.25
        for (i in 1..1_0000) {
            res += (LognormalDistribution.generate(mu, sigma) * 100).toInt().toString() + ", "
        }
        println(res)
    }
}
