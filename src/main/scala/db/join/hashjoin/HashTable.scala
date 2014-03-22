package main.scala.db.join.hashjoin

import scala.collection.mutable._

class HashTable(buckets:Int) {
  
  class HTIterator(bucket:Int){
    //you must init the member
    private var i=0
    
    def getTuple():Int={
	  hashTable(bucket)(i)
    }
    def next(){
      i+=1
    }
  }
  
  val HASH_BUCKETS=buckets
  private var hashTable=new Array[ArrayBuffer[Int]](HASH_BUCKETS)
  
  def init(){
//    	private var hashTable=new Array[ArrayBuffer[Int]](10) why this is wrong
    for(i <- 0 until HASH_BUCKETS)
      hashTable(i)=new ArrayBuffer[Int]
    println("hashtable inited!")
  }
  
  def test(){//how object and class access the private member each other
  }
  
  def insert(bucket: Int, key: Int){//must support generic
    hashTable(bucket)+=key
    println("haha")
  }
  
  def placeIterator(bucket:Int):HTIterator={
    new HTIterator(bucket)
  }
}

object HashTable{
  private val test1=111
  val hashtable=new HashTable(10)// you must new a instance
  def main(args:Array[String])={
    hashtable.init
    for(i <- 1 to 5)
      hashtable.insert(1, i)
	val hi=hashtable.placeIterator(1)
    for(i <- 1 to 5){
      println(hi.getTuple)
      hi.next
    }
  }
}