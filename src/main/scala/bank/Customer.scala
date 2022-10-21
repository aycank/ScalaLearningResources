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

  // Accounts ListBuffer to store all accounts the user has
  var accounts = new ListBuffer[Account]

  /*
  If the user successfully logged in, they will be directed to this start page. Here they can select between
  multiple options: Seeing their details, updating their details, adding a new Checkings or Savings account,
  entering in to one of those accounts, deleting an account, seeing all details of each of their accounts,
  contacting the support team, and finally logging out. Whatever they chose will call the respective function.
   */
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
        case 2 => updateDetails(customer)
        case 3 => addAccount(customer)
        case 4 => enterAccount(customer)
        case 5 => deleteAccount(customer)
        case 6 => getAccounts()
        case 7 => support()
        case 10 =>
          logLogOut(customer)
          print("Logging out.") // 'Animation' to simulate the loading process of logging out
          Thread.sleep(500)
          print(".")
          Thread.sleep(500)
          println(".")
          Thread.sleep(750)
        case _ => println("Invalid Option")
      }
    }
  }

  /*
    Function to get and print out the details for the customer, displaying their name, postcode, unique ID and PIN
    number used for logging in and out
   */
  def getDetails() : Unit ={
    println("-------------------------------")
    println("Name: " + fullName)
    println("Postcode: " + pCode)
    println("ID: " + uID)
    println("PIN Code: " + pin)
  }

  /*
  Function to get more simplified details of the user, which is only displayed to the admin. Uses less space
   */
  def adminGetDetails() : Unit = {
    println("Acc" + id + ": FName-" + fullName + "  PCode-" + pCode + "  ID-" + uID + "  PIN-" + pin)
  }

  /*
  Function to update details for the user. The user chooses whether they would like to change their name or postcode,
  or just go back to the customer start page. Each choice will call their respective function.
   */
  def updateDetails(customer: Customer) : Unit = {
    var choice : Int = 0
    while(choice != 10){
      println("What Would You Like To Update:\n" +
        "1. Name\n" +
        "2. Postcode\n" +
        "10. Back")
      choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => setName(customer)
        case 2 => setPostcode(customer)
        case 10 => choice = 10
        case _ => println("Invalid Option")
      }
    }
  }

  /*
  Function for the customer to add an account. They are given a choice whether they would like to add a checkings
  account or a savings account, or go back to the customer start page. Whatever choice they make will call the
  respective function
   */
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

  /*
  Function to add a checking account. This account will be added and stored to the accounts ListBuffer. Account
  Creation will also get logged.
   */
  def addChecking(customer: Customer) : Unit = {
    val id = accounts.size + 1
    val checkingAccount = new CheckingAccount(id)
    accounts += checkingAccount
    logCheckingCreation(customer)
    println("Credit Account Successfully Added")
  }

  /*
  Function to add a savings account. This account will be added and stored to the accounts ListBuffer. Account
  Creation will also get logged.
   */
  def addSavings(customer: Customer) : Unit = {
    val id = accounts.size + 1
    val savingsAccount = new SavingsAccount(id)
    accounts += savingsAccount
    logSavingsCreation(customer)
    println("Savings Account Successfully Added")
  }

  /*
  Function to enter in to a specific account, as long as that account has been created. Iterates through the list
  of current accounts (if any) and prints their details. When the user chooses what account to enter, it checks to
  see if the account exists. If it does, the user enters the start function from the Account class
   */
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

  /*
  Function to delete an account. Iterates through the list of current accounts (if any) and prints their simplified
  details. When the user chooses what account to delete, it first checks to see if any money is currently in the
  account. If there is money, it tells the user to first deposit all money out in order to remove the account. If there
  is no money, the account is removed from the accounts Listbuffer
   */
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
          if(account.getBalance() > 0){ // Checks if account has money in it (cant remove if money in account)
            checked = true
            println("Please Withdraw all cash before deleting the account")
          }else{
            // Checks if account type is Checking or Savings
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
          print("Deleting.") // 'Animation' to simulate the loading process of deleting an account
          Thread.sleep(500)
          print(".")
          Thread.sleep(500)
          println(".")
          Thread.sleep(750)
          println("Checkings Account Successfully Deleted")
          accounts -= accounts(index) // Account removed from accounts ListBuffer
          logCheckingDeletion(customer)
        }else if (accountType == "Savings"){
          print("Deleting.") // 'Animation' to simulate the loading process of deleting an account
          Thread.sleep(500)
          print(".")
          Thread.sleep(500)
          println(".")
          Thread.sleep(750)
          println("Savings Account Successfully Deleted")
          accounts -= accounts(index) // Account removed from accounts ListBuffer
          logSavingsDeletion(customer)
        }
      }
      if (!checked) {
        println("Invalid Option")
      }
    }
  }

  /*
  Function to get all account details and print them out. Iterates through the account ListBuffer and get their
  details
   */
  def getAccounts() : Unit = {
    for(account <- accounts) account.getDetails()
  }

  /*
  Function for contacting the support team. Simulates that there are no agents at the moment, and they are currently
  busy
   */
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

  /*
  Function to get the name of the customer
   */
  def getName() : String = fullName

  /*
  Function to get the postcode of the customer
   */
  def getPostCode() : String = pCode

  /*
  Function to change the name of the customer. This name change gets logged
   */
  private def setName(customer: Customer) : Unit ={
    println("Enter new First Name: ")
    val newFName = readLine().capitalize
    println("Enter new Last Name: ")
    val newLName = readLine().capitalize
    fullName = newFName + " " + newLName
    logChangeName(customer)
  }

  /*
  Function to change the postcode of the customer. The postcode change gets logged
   */
  private def setPostcode(customer: Customer) : Unit = {
    println("Enter new Postcode:")
    val newPostcode = readLine().toUpperCase()
    pCode = newPostcode
    logChangePostCode(customer)
  }

  /*
  Function to log every time a user creates a Checking Account. This will be written in the log.txt file
   */
  def logCheckingCreation(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " New Account Added for Customer ID: " + customer.id + " (" + customer.getName() + ")" +
        " Type: Checking\n")
  }

  /*
  Function to log every time a user deletes a Checking Account. This will be written in the log.txt file
   */
  def logCheckingDeletion(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + "). Deleted Account Type: " +
        "Checking\n")
  }

  /*
  Function to log every time a user creates a Savings Account. This will be written in the log.txt file
   */
  def logSavingsCreation(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " New Account Added for Customer ID: " + customer.id + " (" + customer.getName() + ") " +
        "Type: Savings\n")
  }

  /*
  Function to log every time a user deletes a Savings Account. This will be written in the log.txt file
   */
  def logSavingsDeletion(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Deleted Account Type: " +
        "Savings\n")
  }

  /*
  Function to log when the customer logs out of their account. This will be written in the log.txt file
   */
  def logLogOut(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Logged out\n")
  }

  /*
  Function to log when a user changes their name. This will be written in the log.txt file
   */
  def logChangeName(customer : Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " Changed Name to " + customer.getName() + "\n")
  }

  /*
  Function to log when a user changes their postcode. This will be written in the log.txt file
   */
  def logChangePostCode(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " Changed Postcode to " + customer.getPostCode() + "\n")
  }

  def this(id : Int, name : String, pcode : String, uid : Int, pin : Int){
    this(id, name, pcode)
    this.uID = uid
    this.pin = pin
  }
}
