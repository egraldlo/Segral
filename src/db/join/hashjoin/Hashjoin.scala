package db.join.hashjoin

import common.Reader
import db.join.hashjoin.HashTable
port common.HashTable

class Hashjoin {
  
  def build(left: Iterator[String]){
	//traverse the whole left child and build a hashtable
    val ht=new HashTable(10)
    ht.init
    //TODO: support the "case"
	left.foreach(line=>println(line.split(" ").length))
  }
  
  def probe(left: Iterator[String]){
  }
  
  def print(){
  }
}

object Hashjoin{
  
  val hashFunctionMode=10
  def main(args:Array[String])={
    println("this is hashjoin algorithm implemetation!")
    //TODO: this will support the binary of data, but scala don't support read data
    //from binary source, so we can use built-in java code to read data
    
    /*--------------left child--------------*/
    val leftReader=new Reader("D:/scala/data/left.txt")
	leftReader.openFile()
	val leftIterator=leftReader.getIterator
	//put the first of the tuple into a head, and use the index of the tuple to 
	//be the tail, and we can use the <first,second> pair to represent the whole
	//tuple, and hash the "first" to generate a key, store it in the hashtable

	/*--------------right child--------------*/
	val rightReader=new Reader("D:/scala/data/left.txt")
	rightReader.openFile()
	val rightIterator=rightReader.getIterator
    
	/*-----------hashjoin instance-----------*/
    val hj=new Hashjoin()
    hj.build(leftIterator)
    hj.probe(rightIterator)
    
  }
}