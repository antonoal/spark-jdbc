package spark.jdbc

import java.sql.{SQLWarning, Savepoint, Connection => JConnection, _}
import java.util
import java.util.Properties
import java.util.concurrent.Executor

import org.apache.spark.sql.SparkSession
/**
  * Created by antonoal on 27/11/2016.
  */
object ConnectionImpl {
  def apply(sess: SparkSession): ConnectionImpl = new ConnectionImpl(sess)
}

class ConnectionImpl(val sess: SparkSession) extends JConnection {

  override def setAutoCommit(autoCommit: Boolean): Unit = ???

  override def setHoldability(holdability: Int): Unit = ???

  override def clearWarnings(): Unit = ???

  override def getNetworkTimeout: Int = ???

  override def createBlob(): Blob = ???

  override def createSQLXML(): SQLXML = ???

  override def setSavepoint(): Savepoint = ???

  override def setSavepoint(name: String): Savepoint = ???

  override def createNClob(): NClob = ???

  override def getTransactionIsolation: Int = ???

  override def getClientInfo(name: String): String = ???

  override def getClientInfo: Properties = ???

  override def getSchema: String = ???

  override def setNetworkTimeout(executor: Executor, milliseconds: Int): Unit = ???

  override def getMetaData: DatabaseMetaData = ???

  override def getTypeMap: util.Map[String, Class[_]] = ???

  override def rollback(): Unit = ???

  override def rollback(savepoint: Savepoint): Unit = ???

  override def createStatement(): StatementImpl = StatementImpl(sess)

  override def createStatement(resultSetType: Int, resultSetConcurrency: Int): StatementImpl = ???

  override def createStatement(resultSetType: Int, resultSetConcurrency: Int, resultSetHoldability: Int): StatementImpl = ???

  override def getHoldability: Int = ???

  override def setReadOnly(readOnly: Boolean): Unit = ???

  override def setClientInfo(name: String, value: String): Unit = ???

  override def setClientInfo(properties: Properties): Unit = ???

  override def isReadOnly: Boolean = ???

  override def setTypeMap(map: util.Map[String, Class[_]]): Unit = ???

  override def getCatalog: String = ???

  override def createClob(): Clob = ???

  override def nativeSQL(sql: String): String = ???

  override def setTransactionIsolation(level: Int): Unit = ???

  override def prepareCall(sql: String): CallableStatement = ???

  override def prepareCall(sql: String, resultSetType: Int, resultSetConcurrency: Int): CallableStatement = ???

  override def prepareCall(sql: String, resultSetType: Int, resultSetConcurrency: Int, resultSetHoldability: Int): CallableStatement = ???

  override def createArrayOf(typeName: String, elements: scala.Array[AnyRef]): Array = ???

  override def setCatalog(catalog: String): Unit = ???

  override def close(): Unit = sess.stop()

  override def getAutoCommit: Boolean = ???

  override def abort(executor: Executor): Unit = ???

  override def isValid(timeout: Int): Boolean = ???

  override def prepareStatement(sql: String): PreparedStatement = StatementImpl(sess, sql)

  override def prepareStatement(sql: String, resultSetType: Int, resultSetConcurrency: Int): PreparedStatement = ???

  override def prepareStatement(sql: String, resultSetType: Int, resultSetConcurrency: Int, resultSetHoldability: Int): PreparedStatement = ???

  override def prepareStatement(sql: String, autoGeneratedKeys: Int): PreparedStatement = ???

  override def prepareStatement(sql: String, columnIndexes: scala.Array[Int]): PreparedStatement = ???

  override def prepareStatement(sql: String, columnNames: scala.Array[String]): PreparedStatement = ???

  override def releaseSavepoint(savepoint: Savepoint): Unit = ???

  override def isClosed: Boolean = ???

  override def createStruct(typeName: String, attributes: scala.Array[AnyRef]): Struct = ???

  override def getWarnings: SQLWarning = ???

  override def setSchema(schema: String): Unit = ???

  override def commit(): Unit = ???

  override def unwrap[T](iface: Class[T]): T = ???

  override def isWrapperFor(iface: Class[_]): Boolean = ???
}
