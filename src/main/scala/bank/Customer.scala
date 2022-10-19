package bank

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}
import scala.util.Random
import scala.util.control.Breaks._

class Customer(number : Int, name : String, postcode : String) {
  var id : Int = number
  private var fullName : String = name
  private var pCode : String = postcode
  var uID: Int = Random.between(100000, 999999)
  var pin: Int = Random.between(1000, 9999)
  var accounts = new ListBuffer[Account]

  def start() : Unit = {
    println("Hello " + fullName)
    var choice : Int = 0
    while(choice != 10){
      println("1. See Details\n" +
        "2. Update Details\n" +
        "3. Add Account\n" +
        "4. Enter Account\n" +
        "5. Delete Account\n" +
        "6. See Accounts\n" +
        "7. Support\n" +
        "10. Logout")
      choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => getDetails()
        case 2 => updateDetails()
        case 3 => addAccount()
        case 4 => enterAccount()
        case 5 => // deleteAccount()
        case 6 => getAccounts()
        case 7 => // support()
        case 10 => choice = 10
      }
    }
  }

  def getDetails() : Unit ={
    println("-------------------------------")
    println("Name: " + fullName)
    println("Postcode: " + pCode)
    println("ID: " + uID)
    println("PIN Code: " + pin)
  }

  def adminGetDetails() : Unit = {
    println("Acc" + id + ": FName-" + fullName + "  PCode-" + pCode + "  ID-" + uID + "  PIN-" + pin)
  }

  def updateDetails() : Unit = {
    var choice : Int = 0
    while(choice != 10){
      println("What Would You Like To Update:\n" +
        "1. Name\n" +
        "2. Postcode\n" +
        "10. Back")
      choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => setName()
        case 2 => setPostcode()
        case 10 => choice = 10
        case _ => println("Invalid Option")
      }
    }
  }
  def addAccount() : Unit = {
    var choice : Int = 0
    while(choice != 10){
      println("What Would You Like To Add:\n" +
        "1. Credit\n" +
        "2. Savings\n" +
        "10. Back")
      choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => addCredit()
        case 2 => addSavings()
        case 10 => choice = 10
        case _ => println("Invalid Option")
      }
    }
  }

  def addCredit() : Unit = {
    val id = accounts.size + 1
    val creditAccount = new CreditAccount(id)
    accounts += creditAccount
  }

  def addSavings() : Unit = {
    val id = accounts.size + 1
    val savingsAccount = new SavingsAccount(id)
    accounts += savingsAccount
  }

  def enterAccount() : Unit = {
    if(accounts.isEmpty) {
      println("No Accounts Created")
    }else{
      println("Which Account Would You Like To Access: ")
      for(account <- accounts){
        print(account.getID() + ". ")
        account.getSimpleDetails()
      }
      val choice = readInt()
      for(account <- accounts){
        if(account.id == choice){
          account.start()
        }
      }
      println("Invalid Option")
      start()
    }
  }

  def getAccounts() : Unit = {
    for(account <- accounts) account.getDetails()
  }

  def getName() : String = fullName

  def getPostCode() : String = pCode

  private def setName() : Unit ={
    println("Enter new First Name Followed by new Last Name (No Spaces):")
    val newName = readLine()
    fullName = newName
  }

  private def setPostcode() : Unit = {
    println("Enter new Postcode:")
    val newPostcode = readLine().toUpperCase()
    pCode = newPostcode
  }

  def this(id : Int, name : String, pcode : String, uid : Int, pin : Int){
    this(id, name, pcode)
    this.uID = uid
    this.pin = pin
  }
}
