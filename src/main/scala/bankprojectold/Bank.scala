package bankprojectold

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

class Bank {
  var interestRate: Double = 1.5
  val customers = new ListBuffer[Customer]()
  val idAndPin = new ListBuffer[String]()
  private val info = new ListBuffer[String]()

  def addCustomer(): Unit = {
    print("Enter your First Name: ")
    val fName = readLine.capitalize
    print("Enter your Last Name: ")
    val lName = readLine.capitalize
    print("Enter your Postcode: ")
    val postCode = readLine
    val newCustomer = new Customer(fName,lName,postCode)
    customers += newCustomer
    info += fName + lName + postCode
    println(info)
    idAndPin += newCustomer.getID + newCustomer.getPin
    println(idAndPin)
    println("-------------------------------\nHello " + fName + " " + lName + "!\nID: "
      + newCustomer.getID + "\nPIN: " + newCustomer.getPin + "\nDO NOT FORGET THEM!\n-------------------------------")
  }

  def existingCustomer() : String = {
    print("First Name: ")
    val fName = readLine.capitalize
    print("Last Name: ")
    val lName = readLine.capitalize
    print("Postcode: ")
    val postCode = readLine
    print("ID: ")
    val id = readLine
    print("PIN: ")
    val pin = readLine
    if(info.contains(fName + lName + postCode)){
      println("Success!\nWelcome " + fName+ " " + lName)
      id + pin
    }else{
      println("Invalid Login Details")
      null
    }
  }

  def getCustomers() :Unit ={
    if (customers.isEmpty) println("No Customers.\n")
    else{
      for(a <- customers){
        a.getDetails()
      }
    }
  }
}
