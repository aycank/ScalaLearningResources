package bankprojectold

import scala.io.StdIn.{readLine, readInt}

object BankMain {
  def main(args: Array[String]): Unit = {
    val bank = new Bank
    printMenu()
    start()
    def start() : Unit ={
      var choiceBank: Int = 0
      while (choiceBank != 10) {
        println("Please select one of the following options:\n" +
          "1) Add Account\n" +
          "2) Login\n" +
          "3) Get Customers\n" +
          "10) Exit")
        choiceBank = readInt()
        choiceBank match {
          case 1 => bank.addCustomer()
          case 2 =>
            val uniqueID = bank.existingCustomer()
            println("unique id: " + uniqueID)
            val userIndex = bank.idAndPin.indexOf(uniqueID)
            customer(userIndex)
          case 3 => bank.getCustomers()
          case 10 => choiceBank = 10
        }
      }
    }
    def customer(userIndex : Int) : Unit = {
      println(userIndex)
      val user = bank.customers(userIndex)
      var choiceCustomer : Int = 0
      while(choiceCustomer != 10){
        println("Hello!\n" +
          "1. See Details\n" +
          "2. Add Account\n" +
          "3. Delete Account\n" +
          "4. See Accounts\n" +
          "5. Support\n" +
          "6. Logout\n" +
          "10. Exit")
        choiceCustomer = scala.io.StdIn.readInt()
        choiceCustomer match {
          case 1 =>
          case 2 => user.addAccount
          case 3 =>
          case 4 =>
          case 5 =>
          case 6 => start()
          case 10 => choiceCustomer = 10
        }
      }
    }
    def account(): Unit ={
      var choiceAccount : Int = 0
      while(choiceAccount != 10){
        println("Please select one of the following options:\n" +
          "1. Deposit to Account\n" +
          "2. Withdraw from Account\n" +
          "3. Check Account Balance\n" +
          "4. Check Details\n" +
          "10. Exit")
        choiceAccount = scala.io.StdIn.readInt()
        choiceAccount match{
          //case 1 => a.depositCash()
          //case 2 => a.withdrawCash()
          //case 3 => a.checkBalance()
          //case 4 => a.checkDetails()
          case 10 => start()
        }
      }
    }
  }
  private def printMenu(): Unit = {
    println("-------------------------------")
    println("|                              |")
    println("|     Welcome to the Bank      |")
    println("|                              |")
    println("-------------------------------")
  }
}



