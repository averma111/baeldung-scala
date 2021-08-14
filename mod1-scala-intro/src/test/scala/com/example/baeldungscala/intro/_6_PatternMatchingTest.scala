package com.example.baeldungscala.intro

import org.junit.Test
import org.junit.jupiter.api.Assertions

class _6_PatternMatchingTest {

  @Test
  def shouldComputeRecursiveFunction_usingPatternMatching = {
    Assertions.assertEquals(13, fibonacci(6))
  }

  def fibonacci(n: Int): Int = {
    n match {
      case 0 | 1 => 1
      case x if x > 1 => fibonacci(x-1) + fibonacci(x-2)
    }
  }
}
