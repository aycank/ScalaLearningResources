package com.wiley.testing

import org.scalatest.funsuite.AnyFunSuite
import bank._

class accountTest extends AnyFunSuite{
  test("Test Checkings Account Creation"){
    val newCheckings = new CheckingAccount(1)

    assert(newCheckings.id === 1)
    assert(newCheckings.getBalance() === 0.00)
  }

  test("Test Savings Account Creation"){
    val newSavings = new SavingsAccount(1)

    assert(newSavings.id === 1)
    assert(newSavings.getBalance() === 0.00)
  }
}
