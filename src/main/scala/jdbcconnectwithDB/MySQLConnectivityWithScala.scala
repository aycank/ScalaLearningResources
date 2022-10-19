package jdbcconnectwithDB

import java.sql.{Connection, DriverManager}

object MySQLConnectivityWithScala extends App{

  val driver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/MySQL80"
  val username = "root"
  val password = "password123"

  // Connection Instance Creation
  var connection:Connection = null
  try{
    Class.forName(driver)
    connection = DriverManager.getConnection(url,username,password)

    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("select title,genre from movies")
    while(resultSet.next()){
      val title = resultSet.getString("title")
      val genre = resultSet.getString("genre")
      println(s"title of movie is ${title} and genre of movie is ${genre}")
    }
  }
  catch{
    case e: Exception => e.printStackTrace()
  }
  finally {
    connection.close()
  }
}
