package com.example.baeldungscala.intro

import org.junit.jupiter.api.{Assertions, Test}

class _1_MethodDefinitionTest {

  @Test
  def shouldComputeAverage(): Unit = {
    Assertions.assertEquals(15, computeAverage(10, 20))
  }

  def computeAverage(x: Double, y: Double): Double = {
    (x + y) / 2
  }

  @Test
  def canDeclareAndInvokeMethodWithoutParenthesisWhenNoArgs_andNoArgParenthesisWhenNoBody(): Unit = {
    Assertions.assertTrue(List("Heads", "Tails").contains(coinToss))
  }

  def coinToss: String = if (Math.random() > 0.5) "Heads" else "Tails"

}
