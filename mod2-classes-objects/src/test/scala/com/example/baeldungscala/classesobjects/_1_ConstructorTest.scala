package com.example.baeldungscala.classesobjects

import com.example.baeldungscala.classesobjects.utils.SysOutCaptor
import org.junit.jupiter.api.{AfterEach, Assertions, BeforeEach, Test}

class _1_ConstructorTest {

  var outputCaptor: SysOutCaptor = _

  @BeforeEach
  def setUp = {
    outputCaptor = new SysOutCaptor()
    System.setOut(outputCaptor.outputCaptor)
  }

  @AfterEach
  def tearDown = {
    System.setOut(outputCaptor.oldOutput)
  }

  @Test
  def shouldInvokePrint_whenNewClassInstantiated = {
    new Person(age=30)

    Assertions.assertEquals("Hello world from Person", outputCaptor.capturedString)
  }

  class Person(val name: String = "Unknown", var age: Int) {
    println("Hello world from Person")
  }

  @Test
  def shouldInstantiateNewClass_differentlyUsingConstructors = {
    val robot1 = new Robot()
    val robot2 = new Robot(123)
    val robot3 = new Robot("Bender")
    val robot4 = new Robot("Rodriguez", 999)

    Assertions.assertNotNull(robot1)
    Assertions.assertNotNull(robot2)
    Assertions.assertNotNull(robot3)
    Assertions.assertNotNull(robot4)
  }

  private val DEFAULT_ROBOT_CODE = "ROBO_UNKNOWN"
  private val DEFAULT_ROBOT_UNIT_NUMBER = -1

  // Note: Defining secondary constructors requires the default constructor is called
  class Robot(var code: String, var unitNumber: Int) {
    def this(code: String) {
      this(code, DEFAULT_ROBOT_UNIT_NUMBER)
    }

    def this(unitNumber: Int) {
      this(DEFAULT_ROBOT_CODE, unitNumber)
    }

    def this() {
      this(DEFAULT_ROBOT_CODE, DEFAULT_ROBOT_UNIT_NUMBER)
    }
  }
}
