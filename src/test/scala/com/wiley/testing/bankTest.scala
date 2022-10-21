package com.wiley.testing

import org.scalatest.funsuite.AnyFunSuite
import bank._

class bankTest extends AnyFunSuite{
  test("Ensure class Bank is created smoothly"){
    val newBank = new Bank
    assert(newBank.getCustomerList().isEmpty === false)
  }

}
