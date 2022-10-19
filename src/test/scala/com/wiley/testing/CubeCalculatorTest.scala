package com.wiley.testing

import org.scalatest.funsuite.AnyFunSuite
import testcases.CubeCalculator

class CubeCalculatorTest extends AnyFunSuite{

  test("Incorrect Answer"){
    assert(CubeCalculator.cube(3) === 27)
  }
}
