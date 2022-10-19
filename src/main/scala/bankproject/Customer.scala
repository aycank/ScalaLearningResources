package bankproject

import scala.collection.mutable.HashMap
import scala.io.StdIn.readInt
import scala.util.Random

class Customer(fName : String, lName : String, postCode : String){
  private val id : Int = Random.between(100000, 999999)
  private val pin : Int = Random.between(1000, 9999)
  val intPin : String = id.toString + pin.toString
  val map  = new HashMap[String, List[String]].withDefaultValue(Nil)

  def getID: String = id.toString

  def getPin : String = pin.toString

  def getDetails(): Unit = {
    println(fName.capitalize + " " + lName.capitalize + "\nPostcode: " + postCode + "\nID: " + id + "\nPIN: " + pin )
  }
  def addAccount : Unit = {
    println("Choose which Account to Add:\n1) Checkings\n2) Savings")
    val option : Int = readInt
    if(option == 1){
      map(intPin) ::= "Checkings"
    }else if(option == 2){
      map(intPin) ::= "Savings"
    }
  }
  def deleteAccount : Unit = {
    println("Choose which Account to Delete:\n1) Checkings\n2) Savings")
    val option : Int = readInt
    if(option == 1){
      map(intPin) ::= "Checkings"
    }else if(option == 2){
      map(intPin) ::= "Savings"
    }
  }
}
