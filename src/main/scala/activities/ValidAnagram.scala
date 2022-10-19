package activities

object ValidAnagram extends App{
  def isAnagram(s: String, t: String): Boolean = {
    var map : Map[Char, Int] = Map()
    if(s.length() != t.length()) return false;

    for(i <- 0 until s.length) {
      // put value in hashmap, if value exists, get the s.charAt(i) value, otherwise, 0.
      map + (s.charAt(i) -> (map.getOrElse(s.charAt(i), 0) + 1))
    }
    for(i <- 0 until t.length){
      // if map doesn't contain key, anagram not found, false
      if(!map.contains(t.charAt(i))){
        return false;
      }
      // If the value of the specific key is greater than 0, reduce it by 1
      else if(map.get(t.charAt(i)).exists(_ > 0)){
        println("got here")
        //map + (t.charAt(i) -> map.get(t.charAt(i)) - 1)
      }
      else{
        return false
      }
    }
    true
  }
  println(isAnagram("anagram", "nagaram"))
}
