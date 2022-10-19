package testcases.threads

class CreateThread extends Thread{
  override  def run(): Unit ={
    try{
      Thread.sleep(3000)
      println("Do parallel computation here"+Thread.currentThread().getName)
      Thread.sleep(2000)
      println("we are back "+Thread.currentThread().getName)
    }catch{
      case e:Exception=> e.printStackTrace()
    }

  }

}
object MainObject extends App{
  var t= new CreateThread()
  var t1= new CreateThread()
  var t2= new CreateThread()
  var t3= new CreateThread()


  t.start()
  //t.start()
  try{
    println("the current thread name is "+Thread.currentThread().getName)
    t.join()
  }catch{
    case e:Exception=> e.printStackTrace()
  }
  t1.start()
  try{
    println("the current thread name is "+Thread.currentThread().getName)
    t1.join()
  }catch{
    case e:Exception=> e.printStackTrace()
  }

  t2.start()
  try{
    println("the current thread name is "+Thread.currentThread().getName)
    t2.join()
  }catch{
    case e:Exception=> e.printStackTrace()
  }

  t3.start()




}

