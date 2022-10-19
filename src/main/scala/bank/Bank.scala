package bank

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

class Bank {
  private val customers = new ListBuffer[Customer]
  var admin = new Customer(0, "admin", "admin", 123, 123)
  customers += admin

  def addCustomer(): Unit = {
    val id = customers.size
    println("Enter your First Name: ")
    val fName: String = readLine.capitalize
    println("Enter your Last Name: ")
    val lName: String = readLine.capitalize
    val fullName = fName + " " + lName
    println("Enter your current Address' Postcode: ")
    val pCode: String = readLine().toUpperCase()

    val customer = new Customer(id, fullName, pCode)
    customers += customer
    println("Account Created Successfully")
    customer.getDetails()
    println("\nREMEMBER YOUR ID AND PIN AS YOU\nWILL NEED IT FOR LOGGING IN")
    println("-------------------------------")
  }


  def login(): Unit = {
    println("Enter your ID: ")
    val id = readInt()
    println("Enter your PIN: ")
    val pin = readInt()
    for (customer <- customers) {
      if ((id == 123) && (pin == 123)) {
        println("Welcome Admin")
        adminStart()
      } else if ((customer.uID == id) && (customer.pin == pin)){
        println("Successfully Logged in")
        customer.start()
      }
    }
    println("Invalid ID and/or PIN")
    start()
  }

  def getCustomers() : Unit = for(customer <- customers) customer.adminGetDetails()

  def findCustomer() : Unit = {
    var choice : Int = 0
    while (choice != 10) {
      println("Find Customer By:\n" +
      "1. ID\n" +
      "2. FullName\n" +
      "3. Postcode\n" +
      "10. Back")
      choice = readInt
      choice match {
        case 1 => findCustomerID()
        case 2 => findCustomerName()
        case 3 => findCustomerPostcode()
        case 10 => adminStart()
        case _ => println("Invalid Option")
      }
    }
  }
  def findCustomerID() : Unit = {
    println("Enter Account Number (Index): ")
    val input = readInt()
    for(customer <- customers){
      if(customer.id == input){
        customer.adminGetDetails()
        adminStart()
      }
    }
    println("Account Number Does Not Exist")
  }

  def findCustomerName() : Unit = {
    var counter : Int = 0
    val customerList = new ListBuffer[Customer]
    println("Enter First Name: ")
    val fName = readLine().capitalize
    println("Enter Last Name: ")
    val lName = readLine().capitalize
    val input = fName + " " + lName
    for(customer <- customers){
      if(customer.getName() == input){
        customerList += customer
        counter += 1
      }
    }
    if (customerList.isEmpty) {
      println("Name Does Not Exist")
    } else {
      println(counter + " Found:\n")
      customerList.foreach(_.adminGetDetails())
    }
  }

  def findCustomerPostcode() : Unit = {
    var counter : Int = 0
    val customerList = new ListBuffer[Customer]
    println("Enter Postcode: ")
    val input = readLine().toUpperCase()
    for(customer <- customers){
      if(customer.getPostCode() == input){
        customerList += customer
        counter += 1
      }
    }
    if (customerList.isEmpty) {
      println("Postcode does not exist")
    } else {
      println(counter + " Found:\n")
      customerList.foreach(_.adminGetDetails())
    }
  }

  def start(): Unit = {
    var choice: Int = 0
    while (choice != 10) {
      println("Please Select From One of the Following Options:\n" +
        "1. Create an Account\n" +
        "2. Login\n" +
        "10. Exit")
      choice = readInt
      choice match {
        case 1 => addCustomer()
        case 2 => login()
        case 10 => println("Thank you and have a nice day!"); System.exit(0)
        case _ => println("Invalid Option")
      }
    }
  }

  def adminStart() : Unit = {
    var choice: Int = 0
    while (choice != 10) {
      println("Please Select From One of the Following Options:\n" +
        "1. Show All Customers\n" +
        "2. Find Specific Customer\n" +
        "3. Set Interest Rate\n" +
        "10. Logout")
      choice = readInt
      choice match {
        case 1 => getCustomers()
        case 2 => findCustomer()
        case 3 => // setInterest()
        case 10 => println("Logging Out..."); start()
        case _ => println("Invalid Option")
      }
    }
  }

}

object BankMain extends App {
  var bank = new Bank
  println("-------------------------------")
  println("|     Welcome to the Bank      |")
  println("-------------------------------")
  bank.start()
}

