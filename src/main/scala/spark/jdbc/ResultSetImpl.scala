package spark.jdbc

import java.io.{InputStream, Reader}
import java.math.BigDecimal
import java.net.URL
import java.sql.{Array, Date, ResultSetMetaData, SQLWarning, _}
import java.util
import java.util.Calendar

import org.apache.spark.sql.{DataFrame, Row}

/**
  * Created by antonoal on 27/11/2016.
  */
object ResultSetImpl {
  def apply(df: DataFrame): ResultSetImpl = new ResultSetImpl(df)
}

class ResultSetImpl(df: DataFrame) extends ResultSet {

  private lazy val dfIter = df.toLocalIterator()
  private lazy val mdata = ResultSetMdataImpl(df)
  private var _row: Row = _

  def colAt(idx: Int) = _row(idx - 1)

  override def getType: Int = ???

  override def isBeforeFirst: Boolean = ???

  override def next(): Boolean =
    if (dfIter.hasNext) {
      _row = dfIter.next()
      true
    } else false

  override def updateString(columnIndex: Int, x: String): Unit = ???

  override def updateString(columnLabel: String, x: String): Unit = ???

  override def getTimestamp(columnIndex: Int): Timestamp = ???

  override def getTimestamp(columnLabel: String): Timestamp = ???

  override def getTimestamp(columnIndex: Int, cal: Calendar): Timestamp = ???

  override def getTimestamp(columnLabel: String, cal: Calendar): Timestamp = ???

  override def updateNString(columnIndex: Int, nString: String): Unit = ???

  override def updateNString(columnLabel: String, nString: String): Unit = ???

  override def clearWarnings(): Unit = ???

  override def updateTimestamp(columnIndex: Int, x: Timestamp): Unit = ???

  override def updateTimestamp(columnLabel: String, x: Timestamp): Unit = ???

  override def updateByte(columnIndex: Int, x: Byte): Unit = ???

  override def updateByte(columnLabel: String, x: Byte): Unit = ???

  override def updateBigDecimal(columnIndex: Int, x: BigDecimal): Unit = ???

  override def updateBigDecimal(columnLabel: String, x: BigDecimal): Unit = ???

  override def updateDouble(columnIndex: Int, x: Double): Unit = ???

  override def updateDouble(columnLabel: String, x: Double): Unit = ???

  override def updateDate(columnIndex: Int, x: Date): Unit = ???

  override def updateDate(columnLabel: String, x: Date): Unit = ???

  override def isAfterLast: Boolean = ???

  override def updateBoolean(columnIndex: Int, x: Boolean): Unit = ???

  override def updateBoolean(columnLabel: String, x: Boolean): Unit = ???

  override def getBinaryStream(columnIndex: Int): InputStream = ???

  override def getBinaryStream(columnLabel: String): InputStream = ???

  override def beforeFirst(): Unit = ???

  override def updateNCharacterStream(columnIndex: Int, x: Reader, length: Long): Unit = ???

  override def updateNCharacterStream(columnLabel: String, reader: Reader, length: Long): Unit = ???

  override def updateNCharacterStream(columnIndex: Int, x: Reader): Unit = ???

  override def updateNCharacterStream(columnLabel: String, reader: Reader): Unit = ???

  override def updateNClob(columnIndex: Int, nClob: NClob): Unit = ???

  override def updateNClob(columnLabel: String, nClob: NClob): Unit = ???

  override def updateNClob(columnIndex: Int, reader: Reader, length: Long): Unit = ???

  override def updateNClob(columnLabel: String, reader: Reader, length: Long): Unit = ???

  override def updateNClob(columnIndex: Int, reader: Reader): Unit = ???

  override def updateNClob(columnLabel: String, reader: Reader): Unit = ???

  override def last(): Boolean = ???

  override def isLast: Boolean = ???

  override def getNClob(columnIndex: Int): NClob = ???

  override def getNClob(columnLabel: String): NClob = ???

  override def getCharacterStream(columnIndex: Int): Reader = ???

  override def getCharacterStream(columnLabel: String): Reader = ???

  override def updateArray(columnIndex: Int, x: Array): Unit = ???

  override def updateArray(columnLabel: String, x: Array): Unit = ???

  override def updateBlob(columnIndex: Int, x: Blob): Unit = ???

  override def updateBlob(columnLabel: String, x: Blob): Unit = ???

  override def updateBlob(columnIndex: Int, inputStream: InputStream, length: Long): Unit = ???

  override def updateBlob(columnLabel: String, inputStream: InputStream, length: Long): Unit = ???

  override def updateBlob(columnIndex: Int, inputStream: InputStream): Unit = ???

  override def updateBlob(columnLabel: String, inputStream: InputStream): Unit = ???

  override def getDouble(columnIndex: Int): Double = ???

  override def getDouble(columnLabel: String): Double = ???

  override def getArray(columnIndex: Int): Array = ???

  override def getArray(columnLabel: String): Array = ???

  override def isFirst: Boolean = ???

  override def getURL(columnIndex: Int): URL = ???

  override def getURL(columnLabel: String): URL = ???

  override def updateRow(): Unit = ???

  override def insertRow(): Unit = ???

  override def getMetaData: ResultSetMetaData = mdata

  override def updateBinaryStream(columnIndex: Int, x: InputStream, length: Int): Unit = ???

  override def updateBinaryStream(columnLabel: String, x: InputStream, length: Int): Unit = ???

  override def updateBinaryStream(columnIndex: Int, x: InputStream, length: Long): Unit = ???

  override def updateBinaryStream(columnLabel: String, x: InputStream, length: Long): Unit = ???

  override def updateBinaryStream(columnIndex: Int, x: InputStream): Unit = ???

  override def updateBinaryStream(columnLabel: String, x: InputStream): Unit = ???

  override def absolute(row: Int): Boolean = ???

  override def updateRowId(columnIndex: Int, x: RowId): Unit = ???

  override def updateRowId(columnLabel: String, x: RowId): Unit = ???

  override def getRowId(columnIndex: Int): RowId = ???

  override def getRowId(columnLabel: String): RowId = ???

  override def moveToInsertRow(): Unit = ???

  override def rowInserted(): Boolean = ???

  override def getFloat(columnIndex: Int): Float = ???

  override def getFloat(columnLabel: String): Float = ???

  override def getBigDecimal(columnIndex: Int, scale: Int): BigDecimal = ???

  override def getBigDecimal(columnLabel: String, scale: Int): BigDecimal = ???

  override def getBigDecimal(columnIndex: Int): BigDecimal = ???

  override def getBigDecimal(columnLabel: String): BigDecimal = ???

  override def getClob(columnIndex: Int): Clob = ???

  override def getClob(columnLabel: String): Clob = ???

  override def getRow: Int = ???

  override def getLong(columnIndex: Int): Long = ???

  override def getLong(columnLabel: String): Long = ???

  override def getHoldability: Int = ???

  override def updateFloat(columnIndex: Int, x: Float): Unit = ???

  override def updateFloat(columnLabel: String, x: Float): Unit = ???

  override def afterLast(): Unit = ???

  override def refreshRow(): Unit = ???

  override def getNString(columnIndex: Int): String = ???

  override def getNString(columnLabel: String): String = ???

  override def deleteRow(): Unit = ???

  override def getConcurrency: Int = ???

  override def updateObject(columnIndex: Int, x: scala.Any, scaleOrLength: Int): Unit = ???

  override def updateObject(columnIndex: Int, x: scala.Any): Unit = ???

  override def updateObject(columnLabel: String, x: scala.Any, scaleOrLength: Int): Unit = ???

  override def updateObject(columnLabel: String, x: scala.Any): Unit = ???

  override def getFetchSize: Int = ???

  override def getTime(columnIndex: Int): Time = ???

  override def getTime(columnLabel: String): Time = ???

  override def getTime(columnIndex: Int, cal: Calendar): Time = ???

  override def getTime(columnLabel: String, cal: Calendar): Time = ???

  override def updateCharacterStream(columnIndex: Int, x: Reader, length: Int): Unit = ???

  override def updateCharacterStream(columnLabel: String, reader: Reader, length: Int): Unit = ???

  override def updateCharacterStream(columnIndex: Int, x: Reader, length: Long): Unit = ???

  override def updateCharacterStream(columnLabel: String, reader: Reader, length: Long): Unit = ???

  override def updateCharacterStream(columnIndex: Int, x: Reader): Unit = ???

  override def updateCharacterStream(columnLabel: String, reader: Reader): Unit = ???

  override def getByte(columnIndex: Int): Byte = ???

  override def getByte(columnLabel: String): Byte = ???

  override def getBoolean(columnIndex: Int): Boolean = ???

  override def getBoolean(columnLabel: String): Boolean = ???

  override def setFetchDirection(direction: Int): Unit = ???

  override def getFetchDirection: Int = ???

  override def updateRef(columnIndex: Int, x: Ref): Unit = ???

  override def updateRef(columnLabel: String, x: Ref): Unit = ???

  override def getAsciiStream(columnIndex: Int): InputStream = ???

  override def getAsciiStream(columnLabel: String): InputStream = ???

  override def getShort(columnIndex: Int): Short = ???

  override def getShort(columnLabel: String): Short = ???

  override def getObject(columnIndex: Int): AnyRef = colAt(columnIndex) match {
    case v: AnyRef => "42" //v
    case _ => ???
  }

  override def getObject(columnLabel: String): AnyRef = ???

  override def getObject(columnIndex: Int, map: util.Map[String, Class[_]]): AnyRef = ???

  override def getObject(columnLabel: String, map: util.Map[String, Class[_]]): AnyRef = ???

  override def getObject[T](columnIndex: Int, `type`: Class[T]): T = ???

  override def getObject[T](columnLabel: String, `type`: Class[T]): T = ???

  override def updateShort(columnIndex: Int, x: Short): Unit = ???

  override def updateShort(columnLabel: String, x: Short): Unit = ???

  override def getNCharacterStream(columnIndex: Int): Reader = ???

  override def getNCharacterStream(columnLabel: String): Reader = ???

  override def close(): Unit = {}

  override def relative(rows: Int): Boolean = ???

  override def updateInt(columnIndex: Int, x: Int): Unit = ???

  override def updateInt(columnLabel: String, x: Int): Unit = ???

  override def wasNull(): Boolean = ???

  override def rowUpdated(): Boolean = ???

  override def getRef(columnIndex: Int): Ref = ???

  override def getRef(columnLabel: String): Ref = ???

  override def updateLong(columnIndex: Int, x: Long): Unit = ???

  override def updateLong(columnLabel: String, x: Long): Unit = ???

  override def moveToCurrentRow(): Unit = ???

  override def isClosed: Boolean = ???

  override def updateClob(columnIndex: Int, x: Clob): Unit = ???

  override def updateClob(columnLabel: String, x: Clob): Unit = ???

  override def updateClob(columnIndex: Int, reader: Reader, length: Long): Unit = ???

  override def updateClob(columnLabel: String, reader: Reader, length: Long): Unit = ???

  override def updateClob(columnIndex: Int, reader: Reader): Unit = ???

  override def updateClob(columnLabel: String, reader: Reader): Unit = ???

  override def findColumn(columnLabel: String): Int = ???

  override def getWarnings: SQLWarning = ???

  override def getDate(columnIndex: Int): Date = ???

  override def getDate(columnLabel: String): Date = ???

  override def getDate(columnIndex: Int, cal: Calendar): Date = ???

  override def getDate(columnLabel: String, cal: Calendar): Date = ???

  override def getCursorName: String = ???

  override def updateNull(columnIndex: Int): Unit = ???

  override def updateNull(columnLabel: String): Unit = ???

  override def getStatement: StatementImpl = ???

  override def cancelRowUpdates(): Unit = ???

  override def getSQLXML(columnIndex: Int): SQLXML = ???

  override def getSQLXML(columnLabel: String): SQLXML = ???

  override def getUnicodeStream(columnIndex: Int): InputStream = ???

  override def getUnicodeStream(columnLabel: String): InputStream = ???

  override def getInt(columnIndex: Int): Int = ???

  override def getInt(columnLabel: String): Int = ???

  override def updateTime(columnIndex: Int, x: Time): Unit = ???

  override def updateTime(columnLabel: String, x: Time): Unit = ???

  override def setFetchSize(rows: Int): Unit = ???

  override def previous(): Boolean = ???

  override def updateAsciiStream(columnIndex: Int, x: InputStream, length: Int): Unit = ???

  override def updateAsciiStream(columnLabel: String, x: InputStream, length: Int): Unit = ???

  override def updateAsciiStream(columnIndex: Int, x: InputStream, length: Long): Unit = ???

  override def updateAsciiStream(columnLabel: String, x: InputStream, length: Long): Unit = ???

  override def updateAsciiStream(columnIndex: Int, x: InputStream): Unit = ???

  override def updateAsciiStream(columnLabel: String, x: InputStream): Unit = ???

  override def rowDeleted(): Boolean = ???

  override def getBlob(columnIndex: Int): Blob = ???

  override def getBlob(columnLabel: String): Blob = ???

  override def first(): Boolean = ???

  override def getBytes(columnIndex: Int): scala.Array[Byte] = ???

  override def getBytes(columnLabel: String): scala.Array[Byte] = ???

  override def updateBytes(columnIndex: Int, x: scala.Array[Byte]): Unit = ???

  override def updateBytes(columnLabel: String, x: scala.Array[Byte]): Unit = ???

  override def updateSQLXML(columnIndex: Int, xmlObject: SQLXML): Unit = ???

  override def updateSQLXML(columnLabel: String, xmlObject: SQLXML): Unit = ???

  override def getString(columnIndex: Int): String = colAt(columnIndex).toString

  override def getString(columnLabel: String): String = ???

  override def unwrap[T](iface: Class[T]): T = ???

  override def isWrapperFor(iface: Class[_]): Boolean = ???
}
