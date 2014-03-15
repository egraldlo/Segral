package common

import scala.io._

class Reader(fileName: String){
  def openFile(){
    println("the file is open: ");
  }
  def getIterator():Iterator[String]={
    val iterator=Source.fromFile(fileName).getLines();
    iterator;
  }
}