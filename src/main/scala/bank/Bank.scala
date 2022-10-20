package bank

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readDouble, readInt, readLine}
import org.joda.time.DateTime

import java.io.PrintWriter

class Bank {
  private val customers = new ListBuffer[Customer]
  var admin = new Customer(0, "admin", "admin", 123, 123)
  customers += admin

  // Function for adding customer
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
    // Add customer to ListBuffer
    customers += customer
    println("Account Created Successfully")
    logCustomerCreation(customer)
    customer.getDetails()
    println("\nREMEMBER YOUR ID AND PIN AS YOU\nWILL NEED IT FOR LOGGING IN")
    println("-------------------------------")
  }

  // Function to login
  def login(): Unit = {
    var loggedIn: Boolean = false
    println("Enter your ID: ")
    val id = readInt()
    println("Enter your PIN: ")
    val pin = readInt()
    for (customer <- customers) {
      // If admin, redirect to admin startpage
      if ((id == 123) && (pin == 123)) {
        println("Welcome Admin")
        print("Logging in.")
        Thread.sleep(500)
        print(".")
        Thread.sleep(500)
        println(".")
        Thread.sleep(750)
        loggedIn = true
        logLogin(customer)
        adminStart(customer)
        // Else if customer inputs correct id and pin, redirect to customer's start page
      } else if ((customer.uID == id) && (customer.pin == pin)){
        print("Logging in.")
        Thread.sleep(500)
        print(".")
        Thread.sleep(500)
        println(".")
        Thread.sleep(750)
        loggedIn = true
        logLogin(customer)
        customer.start(customer)
      }
    }
    if (!loggedIn){
      println("Invalid ID and/or PIN")
    }
  }

  // Function to get all the customers
  def getCustomers() : Unit = for(customer <- customers) customer.adminGetDetails()

  // Function for finding a customer. User can choose to find them by ID, Full Name or Postcode
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
        case 10 => println("Going Back...")
        case _ => println("Invalid Option")
      }
    }
  }
  // Function to find a customer/s by ID number (index)
  def findCustomerID() : Unit = {
    println("Enter Account Number (Index): ")
    val input = readInt()
    for(customer <- customers){
      if(customer.id == input){
        customer.adminGetDetails()
        adminStart(customer)
      }
    }
    println("Account Number Does Not Exist")
  }

  // Function to find customer/s by first and last name
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

  // Function to find customer/s by postcode
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

  // Starting page when launching the application
  def start(): Unit = {
    var choice: Int = 0
    while (choice != 10) {
      println("Please Select From One of the Following Options:\n" +
        "1. Create an Account\n" +
        "2. Login\n" +
        "10. Exit")
      try {
        choice = readInt()
        choice match {
          case 1 => addCustomer()
          case 2 => login()
          case 10 => println("Thank you and have a nice day!"); System.exit(0)
          case _ => println("Invalid Option")
        }
      } catch {
        case ex: NumberFormatException => println("PLEASE INPUT A DIGIT")
      }
    }
  }

  // Admin login page
  def adminStart(customer: Customer) : Unit = {
    var choice: Int = 0
    while (choice != 10) {
      println("Please Select From One of the Following Options:\n" +
        "1. Show All Customers\n" +
        "2. Find Specific Customer\n" +
        "3. Access Logs\n" +
        "4. Clear Logs\n" +
        "10. Logout")
      choice = readInt
      choice match {
        case 1 => getCustomers()
        case 2 => findCustomer()
        case 3 => getLog()
        case 4 => clearLogs()
        case 10 =>
          print("Logging out.")
          Thread.sleep(500)
          print(".")
          Thread.sleep(500)
          println(".")
          Thread.sleep(750)
          logLogOut(customer)
          start()
        case _ => println("Invalid Option")
      }
    }
  }

  // Function to log when an account is created
  def logCustomerCreation(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " New Customer Account - ID: " + customer.id + " - Full Name: " + customer.getName() +
      " - Postcode: " + customer.getPostCode() + "\n")
  }

  // Function to log everytime a user logs in, writing it in a log.txt file
  private def logLogin(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID " + customer.id + " (" + customer.getName() + ") logged in\n")
  }

  def logLogOut(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Logged out\n")
  }

  // Function to print out all contents on the log.txt file
  private def getLog() : Unit = {
    println(scala.io.Source.fromFile(
      "C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt").mkString)
  }

  // Function to clear all contents on the log.txt file
  private def clearLogs() : Unit = {
    val pw = new PrintWriter(
      "C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt");
    pw.close();
    println("Logs Successfully Cleared.")
  }
}

// Main
object BankMain extends App {
  var bank = new Bank
  println("-------------------------------")
  println("|     Welcome to the Bank      |")
  println("-------------------------------")
  bank.start()
}

