package com.wiley.testing

import org.scalatest.funsuite.AnyFunSuite
import scala.collection.immutable.Queue

class TestQueueFunc extends AnyFunSuite{
  test("Check Queue Front Element"){
    var queue1 = Queue(1,2,3,4,5,6,7,8,9)
    var length1 = queue1.length
    assert(queue1.dequeue._1 === 2)
    assert(queue1.dequeue._2 === length1 - 1)
  }
}
