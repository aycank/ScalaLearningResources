package activities

// If either temperature is less than 0, and the other temperature is either above 100, return true, else false

object Activity3 extends App {
  def tempCheck(temp1: Int, temp2: Int): Boolean = {
    if ((temp1 < 0 && temp2 > 100) || temp2 < 0 && temp1 > 100) true else false
  }

  println(tempCheck(-1, 101))
}
