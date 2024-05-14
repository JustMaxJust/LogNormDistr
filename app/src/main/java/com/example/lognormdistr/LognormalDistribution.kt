package com.example.lognormdistr

import java.util.Random
import kotlin.math.E
import kotlin.math.pow

object LognormalDistribution {
    fun generate(mu: Double, sigma: Double): Double {
        val randomNormal = Random().nextGaussian()
        return E.pow(mu + sigma * randomNormal)
    }
}