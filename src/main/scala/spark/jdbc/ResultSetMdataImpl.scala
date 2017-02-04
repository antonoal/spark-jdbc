package spark.jdbc

import java.sql.{ResultSetMetaData, Types => SqlTypes}

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types.{DataTypes => SparkTypes}

object ResultSetMdataImpl {
  def apply(df: DataFrame): ResultSetMdataImpl = new ResultSetMdataImpl(df)
}

class ResultSetMdataImpl(df: DataFrame) extends ResultSetMetaData {

  private val schema = df.schema
  private def get(idx: Int) = schema(idx - 1)

  override def isDefinitelyWritable(column: Int): Boolean = ???

  override def getScale(column: Int): Int = ???

  override def isCurrency(column: Int): Boolean = false

  override def getColumnType(column: Int): Int = get(column).dataType match {
    case SparkTypes.IntegerType => SqlTypes.INTEGER
    case SparkTypes.LongType => SqlTypes.BIGINT
    case SparkTypes.FloatType => SqlTypes.FLOAT
    case SparkTypes.StringType => SqlTypes.VARCHAR
    case _ => ???
  }

  override def getColumnClassName(column: Int): String = ???

  override def getColumnDisplaySize(column: Int): Int = ???

  override def getColumnCount: Int = schema.size

  override def getPrecision(column: Int): Int = get(column).dataType.defaultSize

  override def isCaseSensitive(column: Int): Boolean = true

  override def getColumnLabel(column: Int): String = getColumnName(column)

  override def isSearchable(column: Int): Boolean = true

  override def getCatalogName(column: Int): String = ???

  override def getColumnName(column: Int): String = get(column).name

  override def isNullable(column: Int): Int =
    if (schema(column - 1).nullable) ResultSetMetaData.columnNullable else ResultSetMetaData.columnNoNulls

  override def isReadOnly(column: Int): Boolean = true

  override def getColumnTypeName(column: Int): String = get(column).dataType.typeName

  override def getSchemaName(column: Int): String = ???

  override def getTableName(column: Int): String = ???

  override def isSigned(column: Int): Boolean = ???

  override def isWritable(column: Int): Boolean = ???

  override def isAutoIncrement(column: Int): Boolean = ???

  override def unwrap[T](iface: Class[T]): T = ???

  override def isWrapperFor(iface: Class[_]): Boolean = ???
}
