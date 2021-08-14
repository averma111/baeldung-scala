package com.example.baeldungscala.intro

import org.junit.Test
import org.junit.jupiter.api.Assertions

class _3_FunctionsTest {

  @Test
  def shouldComputePower_usingNestedFunctions = {
    Assertions.assertEquals(8, computePower(2, 3))
  }

  def computePower(x: Int, y: Int): Int = {
    def power(i: Int, accumulator: Int): Int = {
      if (i <= 0) accumulator
      else power(i - i, x * accumulator)
    }
    power(y, 1)
  }

  @Test
  def shouldCreateFunction_usingHighOrderFunction = {
    def square(x: Int): Int = x * x
    def sum(x: Int, y: Int) = x + y

    def sumTheSquares(a: Int, b: Int) = mapReduce(sum, 0, square, a, b)

    Assertions.assertEquals(385, sumTheSquares(1, 10))
  }

  def mapReduce(reduceFunction: (Int, Int) => Int, i: Int, mapFunction: Int => Int, a: Int, b: Int): Int = {
    def iterate(a: Int, result: Int): Int = {
      if (a > b) result else iterate(a + 1, reduceFunction(mapFunction(a), result))
    }
    iterate(a, i)
  }

  @Test
  def shouldCreateFunction_usingAnonymousFunction = {
    def sumTheSquares(a: Int, b: Int) = mapReduce((x, y) => x + y, 0, x => x * x, a, b)

    Assertions.assertEquals(385, sumTheSquares(1, 10))
  }

  @Test
  def shouldComposeFunctions_usingCurrying = {
    def sumWhenNumberArgIsHigher(computationFunction: Int => Int)(a: Int, b: Int): Int = {
      if (a > b) 0
      else computationFunction(a) + sumWhenNumberArgIsHigher(computationFunction)(a + b, b)
    }

    def computeModulo(n: Int)(x: Int) = x % n

    Assertions.assertEquals(1, computeModulo(5)(6))

    val sumMod5 = sumWhenNumberArgIsHigher(computeModulo(5)) _

    Assertions.assertEquals(10, sumMod5(6, 10))
  }

}
