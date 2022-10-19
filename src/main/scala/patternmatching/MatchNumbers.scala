package patternmatching

class Account(username : String, password : String){
  var user: String = username
  var pass: String = password

}

class ID(id : Int){
  var idNumber: Int = id
}

object MatchNumbers extends  App{
  var id = new ID(1)
  var acc = new Account("admin","123")
  val userInfo : Map[ID, Account] = Map(id -> acc)

  Status(getUsername(userInfo,1))

  def getUsername(userInfo : Map[ID, Account], id : Int) : Option[Account] = {
    var alpha : Option[Account] = None
    val userIDs = userInfo.keys
    var check = false
    for(a <- userIDs) {
      if(a.idNumber.equals(id)) {
        alpha = userInfo.get(a)
        check = true
      }
    }
    if(!check){
      val pt1 : Option[Account] = None
      pt1
    }else{
      alpha
    }
  }
  def Status(student : Option[Account]) : Unit={
    student match {
      case student => println("One" + student)
      case None => println("No")
    }
  }
}