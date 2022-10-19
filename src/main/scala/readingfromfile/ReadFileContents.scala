package readingfromfile

import scala.io.Source

object ReadFileContents extends App{
  println(Source.fromFile("C:\\Users\\Aycan\\testscala.txt").mkString)
}
