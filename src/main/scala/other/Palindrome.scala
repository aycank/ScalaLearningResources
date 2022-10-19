package other

object Palindrome extends App {
  def isPalindrome(s: String): Boolean = {
    var i = 0
    var j = s.length - 1
    while (i < j) {
      val a = s.charAt(i)
      val b = s.charAt(j)
      if (a != b) return false
      i += 1
      j -= 1
    }
    true
  }
  println(isPalindrome("mom"))
}