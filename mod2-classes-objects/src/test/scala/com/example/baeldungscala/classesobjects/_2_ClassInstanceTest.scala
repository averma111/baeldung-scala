package com.example.baeldungscala.classesobjects

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class _2_ClassInstanceTest {

  @Test
  def shouldCreateInstanceOfClass(): Unit = {
    val car: Car = new Car("Toyota", "SUV", "RAV4")

    car start "remote"
    assertEquals(0.0, car.speed)

    car.accelerate(2, 5)
    assertEquals(10.0, car.speed)

    car.brake(1, 3)
    assertEquals(7.0, car.speed)
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
