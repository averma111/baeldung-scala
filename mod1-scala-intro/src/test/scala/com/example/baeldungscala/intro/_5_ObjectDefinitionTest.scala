package com.example.baeldungscala.intro

import org.junit.Test
import org.junit.jupiter.api.Assertions

class _5_ObjectDefinitionTest {

  @Test
  def shouldUseObject_asASingleton = {
    Assertions.assertEquals(15.0, Utils.computeAverage(10, 20))
  }

  object Utils {
    def computeAverage(x: Double, y: Double): Double = {
      (x + y) / 2
    }
  }

}
