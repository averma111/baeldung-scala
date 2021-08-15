package com.example.baeldungscala.classesobjects.utils

import java.io.{ByteArrayOutputStream, PrintStream}

class SysOutCaptor {
  val standardOut: PrintStream = System.out
  val outStreamCaptor: ByteArrayOutputStream = new ByteArrayOutputStream()

  def outputCaptor: PrintStream = new PrintStream(outStreamCaptor)
  def capturedString: String = outStreamCaptor.toString.trim
  def oldOutput: PrintStream = standardOut
  def capturedStringContains(find: String): Boolean = capturedString contains find
}
