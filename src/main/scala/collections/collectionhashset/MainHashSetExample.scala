package collections.collectionhashset

import scala.collection.immutable.HashSet

object MainHashSetExample extends App{
  var hashSet: HashSet[String] = HashSet("name1", "name2", "name3", "name4", "name5", "name6")
  hashSet.foreach((element: String) => {
    var string = "update template number '" + element + "' where project name is '" + element.substring(0,3) + "'"
    println(string)
  })
}
