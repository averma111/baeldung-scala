package com.example.baeldungscala.classesobjects

import org.junit.jupiter.api.{Assertions, Test}

class _3_ExtendingClassTest {

  @Test
  def shouldInheritPropertiesAndMethodsFromParentClass = {
    val toyota = new ToyotaCar("Manual", "SUV", "Prado")

    toyota start "key"
    Assertions.assertEquals(1.0, toyota.speed)

    toyota.accelerate(5, 2)
    Assertions.assertEquals(11.0, toyota.speed)
  }

  class ToyotaCar(transmission: String, brand: String, model: String) extends Car("Toyota", brand, model) {
    override def start(keyType: String): Unit = {
      isOn = true
      speed = 1.0
    }
  }

  class Car(val manufacturer: String, brand: String, var model: String) {
    var speed: Double = 0
    var gear: Any = 0
    var isOn: Boolean = false

    def start(keyType: String): Unit = {
      isOn = true
    }

    def selectGear(gearNumber: Any): Unit = {
      gear = gearNumber
    }

    def accelerate(rate: Double, seconds :Double): Unit = {
      speed += rate * seconds
    }

    def brake(rate: Double, seconds: Double): Unit = {
      speed -= rate * seconds
    }

    def stop(): Unit = {
      speed = 0
      gear = 0
      isOn = false
    }
  }

}
