package objectoriented

trait Opponent{
    var health = 100;
    val rPunch : Int = 15
    def checkHealth() : Unit = {
      print("Health Remaining: " + health + "\tTherefore: ")
      if (health <= 0) println("Opponent is Dead...") else println("Opponent Still Breathing")
    }
  }

  class Combat extends Opponent{
    override val rPunch = 40;
    def rightHook(): Unit ={
      println("Right Fist...")
      health -= rPunch
    }
    def rightUppercut():Unit = {
      println("Right Uppercut!")
      health -= (rPunch + 20)
    }
  }

  class Boxing extends Combat with Opponent{
    override val rPunch = 20;
    override def rightHook():Unit = {
      println("Right Punch...")
      health -= rPunch
    }
    def glovesOff() : Unit = {
      super.rightHook()
    }
  }

  class MMA extends Combat with Opponent{
    def headKick(): Unit ={
      println("GGWP!")
      health -= 100
    }
  }

object Boxing extends App{
  var boxing = new Boxing
  var mma = new MMA
  boxing.rightHook()
  boxing.checkHealth()
  boxing.rightUppercut()
  boxing.checkHealth()
  boxing.rightUppercut()
  boxing.checkHealth()
  mma.headKick()
  mma.checkHealth()
}
