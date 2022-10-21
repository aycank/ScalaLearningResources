package com.wiley.testing

import org.scalatest.funsuite.AnyFunSuite
import bank._

class CustomerTest extends AnyFunSuite{
  test("Customer Class Creation Working"){
    val newCustomer = new Customer(1, "Ben Pappas", "EX46AW")

    assert(newCustomer.getName() === "Ben Pappas")
    assert(newCustomer.getPostCode() === "EX46AW")
    assert(newCustomer.id === 1)
    assert(newCustomer.accounts.isEmpty === true)
  }
}
