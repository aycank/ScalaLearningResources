package testcases

import scala.collection.mutable

object ScalaCollection extends App{
  var stack = new mutable.Stack[Int]
  stack.push(1)
  stack.push(2)
  val oldSize: Int = stack.size
  val result: Int = stack.pop()
}
