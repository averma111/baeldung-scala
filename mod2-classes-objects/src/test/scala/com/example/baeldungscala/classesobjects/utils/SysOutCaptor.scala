package com.example.baeldungscala.classesobjects.utils

import java.io.{ByteArrayOutputStream, PrintStream}

class SysOutCaptor {
  val standardOut: PrintStream = System.out
  val outStreamCaptor: ByteArrayOutputStream = new ByteArrayOutputStream()

  def testingCaptor: PrintStream = new PrintStream(outStreamCaptor)
  def capturedString: String = outStreamCaptor.toString.trim
  def regularCaptor: PrintStream = standardOut
}
