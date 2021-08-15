package com.example.baeldungscala.classesobjects

import org.junit.jupiter.api.{Assertions, Test}

class _4_ImplicitClassTest {

  @Test
  def shouldApplyCustomBehaviorToString_usingImplictClass = {
    import Prediction._

    Assertions.assertEquals(29, "John".predictAge)
  }

  object Prediction {
    // Note: Useful for adding behavior to classes we can't directly modify e.g String
    implicit class AgeFromName(name: String) {
      def predictAge: Int = name.length + 25
    }
  }
}
