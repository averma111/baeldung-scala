package com.example.baeldungscala.classesobjects

import org.junit.Test

class _2_ClassInstanceTest {

  @Test
  def shouldCreateIntanceOfClass(): Unit = {
    // TODO implement assertions
  }

  class Car(val manufacturer: String, brand: String, var model: String) {
    var speed: Double = 0
    var gear: Any = 0
    var isOn: Boolean = false

    def start(keyType: String): Unit = {
      isOn = true
      println(s"Car started using the $keyType")
    }

    def selectGear(gearNumber: Any): Unit = {
      gear = gearNumber
      println(s"Gear has been change to $gearNumber")
    }

    def accelerate(rate: Double, seconds :Double): Unit = {
      speed += rate * seconds
      println(s"Car accelerates at $rate per second for $seconds seconds")
    }

    def brake(rate: Double, seconds: Double): Unit = {
      speed -= rate * seconds
      println(s"Car slows down at $rate per second for $seconds seconds")
    }

    def stop(): Unit = {
      speed = 0
      gear = 0
      isOn = false
      println("Car has stopped")
    }
  }
}
