package hashjoin

import common.Reader
import scala.io.Source
import java.io.File
import java.io.FileInputStream
import java.lang.Integer
import java.io.DataInputStream

class Hashjoin {

}

object Hashjoin{
  def main(args:Array[String])={
    println("this is hashjoin algorithm implemetation!")
	val reader=new Reader("left child data!")
	reader.openFile()
	val iterator=Source.fromFile("D:/scala/data/part-00002").getLines()
	/*由于Scala没有提供读取二进制的方法，直接用Java的*/
//	iterator.foreach(line=>println(line))
	
	val file=new File("D:/scala/data/T0G0P0")
	val in = new FileInputStream(file)
	val data=new DataInputStream(in)
    
    println(data.readLine())    
    println(data.readLine())    

    println(data.readInt())
    println(data.readInt())
    println(data.readInt())
    println(data.readInt())
    println(data.readInt())
    println(data.readInt())
    println(data.readInt())
    println(data.readInt())

    println(data.readInt())
  }
}