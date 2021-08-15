package com.example.baeldungscala.intro

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class _2_ControlStructuresTest {

  @Test
  def canUseIfElse_similarToTernary_andScalaDoesNotHaveTernary = {
    val result = if (10 % 2 == 0) "Even" else "Prime"
    Assertions.assertEquals("Even", result)
  }

  @Test
  def whileLoopSimilarToJava = {
    var count = 0

    while (count < 10) {
      count += 1
    }

    Assertions.assertEquals(10, count)
  }

  @Test
  def doWhileLoopSimilarToJava = {
    var count = 0

    do {
      count += 1
    } while (count < 10)

    Assertions.assertEquals(10, count)
  }

  @Test
  def shouldComputeSumUsingForExpression = {
    Assertions.assertEquals(55, computeSumInRange(1, 10))
  }

  def computeSumInRange(start: Int, end: Int): Int = {
    var sum = 0
    // Note: start to end is a generator expression i.e it generates a series of values
    // i <- start to end defines i as a value from the value produced by the generator expression
    // the for body is executed for each value from the series
    for (i <- start to end) {
      sum += i
    }
    sum
  }

}
