package hashjoin

import common.Reader
import scala.io.Source

class Hashjoin {
  
  def build(){
  }
  def probe(){
  }
  def print(){
  }
}

object Hashjoin{
  def main(args:Array[String])={
    println("this is hashjoin algorithm implemetation!")
    val leftReader=new Reader("D:/scala/data/left.txt")
	leftReader.openFile()
	val leftIterator=leftReader.getIterator
	/*由于Scala没有提供读取二进制的方法，直接用Java的*/
	leftIterator.foreach(line=>println(line))

	val rightReader=new Reader("D:/scala/data/left.txt")
	rightReader.openFile()
	val rightIterator=rightReader.getIterator
	rightIterator.foreach(line=>println(line))
	
  }
}