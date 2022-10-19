package activities

object PalindromeActivity extends App{
  def isPalindrome(s : String) : Boolean = {
    val string : String = s.replaceAll("\\P{Alnum}", "").toLowerCase()
    var pointer : Int = string.length() - 1

    for(i <- 0 until string.length / 2){
      if(string.charAt(i) != string.charAt(pointer)) return false
      pointer -= 1
    }
    true
  }
  println(isPalindrome("A man, a plan, a canal: Panama"))
}
