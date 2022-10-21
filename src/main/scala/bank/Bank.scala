package bank

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readDouble, readInt, readLine}
import org.joda.time.DateTime

import java.io.PrintWriter

class Bank {
  // Create new ListBuffer that will store all customers of type Customer
  private val customers = new ListBuffer[Customer]

  // Create an admin and add it to the customers ListBuffer
  var admin = new Customer(0, "admin", "admin", 123, 123)
  customers += admin

  /*
  Function for adding a customer. The user enters their first and last name, followed by their postcode. A new
  Instance of a customer is then created and added to the customers ListBuffer. The customer is given a unique ID
  and PIN number that they will need to log in.
  (Customer being created is added to the log)
   */
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
    customers += customer // Add customer to customers ListBuffer
    println("Account Created Successfully")
    logCustomerCreation(customer)
    customer.getDetails()
    println("\nREMEMBER YOUR ID AND PIN AS YOU\nWILL NEED IT FOR LOGGING IN")
    println("-------------------------------")
  }

  /*
  Function to login. The user must enter their unique ID and PIN number given to them when creating an account.
  If they input the two numbers correctly, it will redirect them to the customer's start page on the Customer class.
  If the user inputs ID: 123 and PIN: 123, they will log in and be redirected to the admin start page, where they
  have different admin options to choose from
   */
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
        print("Logging in.")  // 'Animation' to simulate the loading process of logging in
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
        print("Logging in.") // 'Animation' to simulate the loading process of logging in
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

  /*
  Function to get all the customer details. Iterates through the customers ListBuffer and prints out all the details
   */
  def getCustomers() : Unit = for(customer <- customers) customer.adminGetDetails()

  /*
  Function used for unit testing purposes
   */
  def getCustomerList() : ListBuffer[Customer] = customers

  /*
  Function to find a customer. The admin chooses whether to find a customer by their index number (in the customer
  ListBuffer), full name, or postcode. Choosing one of the three options will call their respective function
   */
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

  /*
  Function to find the customer with the index number from the customers ListBuffer. After the user inputs a number,
  it iterates through the customers ListBuffer and checks. If it finds a match, it will print the details of that
  specific customer.
   */
  def findCustomerID() : Unit = {
    println("Enter Account Number (Index): ")
    val input = readInt()
    for(customer <- customers){ // Iterate through the customers Listbuffer
      if(customer.id == input){  // If the index is the same, then print the details of that customer
        customer.adminGetDetails()
        adminStart(customer)
      }
    }
    println("Account Number Does Not Exist")
  }

  /*
  Function to find the customer/s with the specific name given. After the user inputs a name, it iterates through
  the customers ListBuffer and checks. If it finds a match, it adds it to the customerList ListBuffer. After it has
  checked, it will print out all the details of each customer.
   */
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
      println(counter + " Found:")
      customerList.foreach(_.adminGetDetails())
    }
  }

  /*
  Function to find the customer/s with the specific postcode. After the user inputs a postcode, it iterates through
  the customers ListBuffer and checks. If it finds a match, it adds it to the customerList ListBuffer. After it has
  checked, it will print out all the details of each customer.
   */
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
      println(counter + " Found: ")
      customerList.foreach(_.adminGetDetails())
    }
  }

  /*
  When the application is loaded, the user is greeted to the start page where they have the option to create an
  account, login or exit the program
   */
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

  /*
  Admin page that gives the user access to certain admin privileges. These include showing all customers,
  finding a specific customer (by index ID, full name or postcode), accessing the logs, and clearing the logs.
  If they choose to log out, they will return back to the start page
   */
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

  /*
  Function to log customer creation and write it in the log.txt file
   */
  def logCustomerCreation(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " New Customer Account - ID: " + customer.id + " - Full Name: " + customer.getName() +
      " - Postcode: " + customer.getPostCode() + "\n")
  }

  /*
  Function to log every time a user logs in to their account. This will be written in the log.txt file
   */
  private def logLogin(customer: Customer): Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID " + customer.id + " (" + customer.getName() + ") logged in\n")
  }

  /*
  Function to log everytime an admin logs out of the system. This writes to a log.txt file
   */
  def logLogOut(customer: Customer) : Unit = {
    val date = new DateTime()
    reflect.io.File("C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt")
      .appendAll("" + date + " Customer ID: " + customer.id + " (" + customer.getName() + ") Logged out\n")
  }

  /*
  Function to retrieve the log and print it to the admin. This will write it to the log.txt file
   */
  private def getLog() : Unit = {
    println(scala.io.Source.fromFile(
      "C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt").mkString)
  }

  /*
  Function to clear the logs and remove all data on it. This will clear the log.txt file
   */
  private def clearLogs() : Unit = {
    val pw = new PrintWriter(
      "C:\\Users\\Aycan\\IdeaProjects\\FirstSBTProject\\src\\main\\scala\\bank\\log.txt");
    pw.close();
    println("Logs Successfully Cleared.")
  }
}

/*
Main function that runs the Application
 */
object BankMain extends App {
  var bank = new Bank
  println("-------------------------------")
  println("|     Welcome to the Bank      |")
  println("-------------------------------")
  bank.start()
}

