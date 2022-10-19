package polymorphism

class Bank {
  private var centralBankROI: Int = 1
  def getRateOfInterest: Int = {
    centralBankROI
  }
  def setRateOfInterest(x : Int): Unit = {
    centralBankROI = x
  }
}

class BofA extends Bank {
  private val barclaysBankROI = 2
  override def getRateOfInterest: Int = {
    println(super.getRateOfInterest)
    super.getRateOfInterest + barclaysBankROI
  }
}

class JpMorgan extends Bank {
  private val jpBankROI = 3
  override def getRateOfInterest: Int = {
    super.getRateOfInterest + jpBankROI
  }
}

object BankPolymorphismExample extends App {
  var bank = new Bank
  var bofa = new BofA
  var jp = new JpMorgan
  bank.setRateOfInterest(10)
  bank.getRateOfInterest
  println(bofa.getRateOfInterest)
  println(jp.getRateOfInterest)

}