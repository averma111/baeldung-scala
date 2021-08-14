package com.example.baeldungscala.intro

import org.junit.jupiter.api.Test

class _1_Test {

  @Test
  def shouldFail() = {
    val num = Integer.parseInt("abc")
    System.out.println(num)
  }

}
