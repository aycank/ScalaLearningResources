package breaktesting

import scala.util.control.Breaks.{break, breakable}

object TestBreak extends App{
  breakable{
    for(i <- 1 to 10 by 2){
      if(i == 7) break else println(i)
    }
  }
}

