package common

import scala.collection.mutable._

class HashTable {
  class HTIterator(bucket:Int){
    private var i=0
    def getNext():Int={
      i+=1
      hashTable(bucket)(i)
    }
  }
  private var hashTable=new Array[ArrayBuffer[Int]](10)
  def init(){
//    	private var hashTable=new Array[ArrayBuffer[Int]](10) why this is wrong
    println("hashtable inited!")
  }
  def test(){//how object and class access the private member each other
  }
  def insert(bucket: Int, key: Int){//must support generic
    hashTable(bucket)+=key
  }
  def placeIterator(bucket:Int):HTIterator={
    new HTIterator(bucket)
  }
}

object HashTable{
  private val test1=111
  val hashtable=new HashTable// you must new a instance
  def main(args:Array[String])={
    hashtable.init
    for(i <- 1 until 5)
      hashtable.insert(0, 9)
	val hi=hashtable.placeIterator(0)
    for(i <-0 to 5)
      println(hi.getNext)
  }
}