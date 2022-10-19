package com.wiley.testing

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import testcases.ScalaCollection

import scala.collection.mutable

class ExampleSuite extends AnyFunSuite with BeforeAndAfter {

  test("1pop is invoked on non empty stack") {
    var s = ""
    before {
      s = "hi"
    }
    test("1pop is invoked on non empty stack") {

      assert(ScalaCollection.result === 2)
      assert(ScalaCollection.stack.size === ScalaCollection.oldSize - 1)
    }
    test("1pop is invoked on an empty stack") {
      val emptyStack = new mutable.Stack[Int]
      intercept[NoSuchElementException] {
        emptyStack.pop()
      }
      assert(emptyStack.isEmpty)
    }
    test("1testing index out of bound") {

      intercept[IndexOutOfBoundsException] {
        s.charAt(-1)
      }
    }

    test("1Testing indexoutofbound with message") {

      val thrown = intercept[IndexOutOfBoundsException] {
        s.charAt(-1)
      }
      //  println()
      assert(thrown.getMessage === "Index -1 out of bounds for length 2")
    }


    after {
      println("Welcome to jhinesh world")
    }
  }
}
