package spark.jdbc

import java.sql.{DriverPropertyInfo, SQLException, Driver => JDriver}
import java.util.Properties
import java.util.logging.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import collection.JavaConversions._

import scala.util.{Failure, Success, Try}
/**
  * Created by antonoal on 27/11/2016.
  */

class DriverImpl extends JDriver {
  override def acceptsURL(url: String): Boolean = url.startsWith("jdbc:spark://")

  override def jdbcCompliant(): Boolean = false

  override def getPropertyInfo(url: String, info: Properties): Array[DriverPropertyInfo] = ???

  override def getMinorVersion: Int = ???

  override def getParentLogger: Logger = ???

  override def connect(url: String, info: Properties): ConnectionImpl = {
    if (acceptsURL(url)) {
      val appName :: master :: Nil = url.split("/").reverse.take(2).toList
      Try {
        val res = info.toMap.keys
          .foldLeft(SparkSession.builder()) {
            case (res, key) => res.config(key, info.getProperty(key))
          }.master(master)
          .appName(appName)
          .getOrCreate()
        res.range(2).createOrReplaceTempView("dual")
        res
      } match {
        case Success(sess) => ConnectionImpl(sess)
        case Failure(ex) => throw new SQLException(ex)
      }
    } else null
  }

  override def getMajorVersion: Int = ???
}
