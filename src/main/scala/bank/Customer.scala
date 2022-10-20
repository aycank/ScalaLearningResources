package bank

import org.joda.time.DateTime

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}
import scala.util.Random

class Customer(number : Int, name : String, postcode : String) {
  var id : Int = number
  private var fullName : String = name
  private var pCode : String = postcode
  var uID: Int = Random.between(100000, 999999)
  var pin: Int = Random.between(1000, 9999)
  var accounts = new ListBuffer[Account]

  def start(customer: Customer) : Unit = {
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
        case 3 => addAccount(customer)
        case 4 => enterAccount(customer)
        case 5 => deleteAccount(customer)
        case 6 => getAccounts()
        case 7 => support()
        case 10 =>
          logLogOut(customer)
          print("Logging out.")
          Thread.sleep(500)
          print(".")
          Thread.sleep(500)
          println(".")
          Thread.sleep(750)
        case _ => println("Invalid Option")
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
  def addAccount(customer: Customer) : Unit = {
    var choice : Int = 0
    while(choice != 10){
      println("What Would You Like To Add:\n" +
        "1. Checking\n" +
        "2. Savings\n" +
        "10. Back")
      choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => addChecking(customer)
        case 2 => addSavings(customer)
        case 10 => choice = 10
        case _ => println("Invalid Option")
      }
    }
  }

  def addChecking(customer: Customer) : Unit = {
    val id = accounts.size + 1
    val checkingAccount = new CheckingAccount(id)
    accounts += checkingAccount
    logCreditCreation(customer)
    println("Credit Account Successfully Added")
  }

  def addSavings(customer: Customer) : Unit = {
    val id = accounts.size + 1
    val savingsAccount = new SavingsAccount(id)
    accounts += savingsAccount
    logSavingsCreation(customer)
    println("Savings Account Successfully Added")
  }

  def enterAccount(customer: Customer) : Unit = {
    var enterAcc: Boolean = false
    if (accounts.isEmpty) {
      println("No Accounts Created")
    } else {
      println("Which Account Would You Like To Access: ")
      for (account <- accounts) {
        print(account.getID + ". ")
        account.getSimpleDetails()
      }
      val choice = readInt()
      for (account <- accounts) {
        if (account.id == choice) {
          enterAcc = true
          account.start(customer)
        }
      }
      if (!enterAcc) {
        println("Invalid Option")
      }
    }
  }

  def deleteAccount(customer: Customer) : Unit = {
    var checked: Boolean = false
    var willDel : Boolean = false
    var accountType : String = ""
    var index : Int = 0
    if (accounts.isEmpty) {
      println("No Accounts")
    } else {
      println("Which Account Would You Like To Delete: ")
      for (account <- accounts) {
        print(account.getID + ". ")
        account.getSimpleDetails()
      }
      val choice = readInt()
      for (account <- accounts) {
        if (account.id == choice) {
          if(account.getBalance() > 0){
            checked = true
            println("Please Withdraw all cash before deleting the account")
          }else{
            println(account.accType)
            if (account.accType == "Checking"){
              checked = true
              willDel = true
              accountType = "Checking"
              index = accounts.indexOf(account)
            }else if (account.accType == "Savings"){
              checked = true
              willDel = true
              accountType = "Savings"
              index = accounts.indexOf(account)
            }
          }
        }
      }
      if(willDel){
        if(accountType == "Checking"){
          accounts -= accounts(index)
          logCreditDeletion(customer)
        }else if (accountType == "Savings"){
          accounts -= accounts(index)
          logSavingsDeletion(customer)
        }
      }
      if (!checked) {
        println("Invalid Option")
      }
    }
  }

  def getAccounts() : Unit = {
    for(account <- accounts) account.getDetails()
  }

  def support() : Unit = {
    print("Connecting you with an agent")
    Thread.sleep(4000)
    print(".")
    Thread.sleep(4000)
    print(".")
    Thread.sleep(4000)
    println(".")
    Thread.sleep(4000)
    println("Sorry, all our agents are busy at the moment. If you email bank@thebank.co.uk, we will get back " +
      "to you as soon as possible.")
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

  // Function to log when a credit account is created
  def logCreditCreation(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " New Account Added for Customer ID: " + customer.id + " (" + customer.getName() + ")" +
        " Type: Credit\n")
  }

  def logCreditDeletion(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + "). Deleted Account Type: " +
        "Credit\n")
  }

  // Function to log when a savings account is created
  def logSavingsCreation(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " New Account Added for Customer ID: " + customer.id + " (" + customer.getName() + ") " +
        "Type: Savings\n")
  }

  def logSavingsDeletion(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Deleted Account Type: " +
        "Savings\n")
  }

  def logLogOut(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Logged out\n")
  }

  def this(id : Int, name : String, pcode : String, uid : Int, pin : Int){
    this(id, name, pcode)
    this.uID = uid
    this.pin = pin
  }
}
