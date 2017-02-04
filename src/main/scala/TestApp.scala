import java.sql._
import java.util.Properties

import spark.jdbc.ConnectionImpl

/**
  * Created by antonoal on 27/11/2016.
  */

object TestApp extends App {

  val driver: String = "spark.jdbc.Driver" // "org.voltdb.jdbc.spark.jdbc.Driver"
  val url: String = "jdbc:spark://local/MyApp" // "jdbc:voltdb://localhost:21212"   "jdbc:spark://local/MyApp"

  val sql = "SELECT * FROM dual"

  try {
    // Load driver. Create connection.

    Class.forName(driver)
    val props = new Properties()
    props.put("spark.ui.enabled", "false")
    //"spark.sql.catalogImplementation" "hive"

    val conn = DriverManager.getConnection(url, props)

//    val ss = conn.asInstanceOf[ConnectionImpl].sess
//    ss.range(10).createOrReplaceTempView("dual")

    // create a statement
    val query = conn.prepareStatement(sql)
    val results = query.executeQuery()
    val mdata = results.getMetaData

    println((1 to mdata.getColumnCount).map(mdata.getColumnLabel).mkString("; "))

    while (results.next()) {
      System.out.println(results.getObject(1))
    }

    //Close statements, connections, etc.
    query.close()
    results.close()
    conn.close()

  } catch {
    case e: Exception => e.printStackTrace()
  }

}
