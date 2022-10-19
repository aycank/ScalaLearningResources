package activities

import scala.collection.mutable.ListBuffer

object StopWhenNotEven extends App {
  var arr = ListBuffer(2,8,19,20,25,50,100,10)

  var even = true

  while (even) {
    if (arr.head % 2 == 0) {
      arr.remove(0)
    } else {
      even = false
    }
  }

  for (x <- arr) {
    print(x + " ")
  }

}
