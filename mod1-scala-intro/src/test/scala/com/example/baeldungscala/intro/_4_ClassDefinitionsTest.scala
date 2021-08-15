package com.example.baeldungscala.intro

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class _4_ClassDefinitionsTest {

  @Test
  def shouldCreateFromClassUsingNewKeyboard = {
    val employee = new Employee("John", 1000)
    employee.incrementSalary()

    Assertions.assertEquals(1020, employee.salary)
    Assertions.assertEquals("name=John, salary=1020", employee toString)
  }

  // Note: using val or var in Constructor means the variables will be public
  class Employee(val name: String, var salary: Int, annualIncrement: Int = 20) {
    // Note: methods are public by default unless specified to be private or protected
    def incrementSalary(): Unit = {
      salary += annualIncrement
    }
    override def toString: String = s"name=$name, salary=$salary"
  }

  @Test
  def shouldImplementSetDataStructure_usingAbstractClasses = {
    val integerSet: IntegerSet = Range(1, 10).foldLeft(new EmptyIntegerSet(): IntegerSet) {
      (x, y) => x add y
    }

    Assertions.assertFalse(integerSet contains 11)
  }

  abstract class IntegerSet {
    def add(x: Int): IntegerSet
    def contains(x: Int): Boolean
  }

  class EmptyIntegerSet extends IntegerSet {
    override def add(x: Int): IntegerSet = new NoneEmptyIntegerSet(x, this)
    override def contains(x: Int): Boolean = false
  }

  class NoneEmptyIntegerSet(
                           val head: Int,
                           val tail: IntegerSet
                           ) extends IntegerSet {
    override def add(x: Int): IntegerSet = {
      if (this contains x) this
      else new NoneEmptyIntegerSet(x, this)
    }

    override def contains(x: Int): Boolean = {
      head == x || (tail contains x)
    }
  }

  @Test
  def shouldApplyTraitFunctionalityToClass_asMixin = {
    val employee = new Employee("John", 1000, 50) with StringUpperCaser
    employee.incrementSalary()

    Assertions.assertEquals(1050, employee.salary)
    Assertions.assertEquals("NAME=JOHN, SALARY=1050", employee toString)
  }

  // Note: Similar to interfaces in Java
  trait StringUpperCaser {
    override def toString: String = super.toString toUpperCase
  }

}
