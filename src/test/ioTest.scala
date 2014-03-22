package test

import scala.io._

object ioTest{
  def main(args:Array[String]){
    println("hello");
    val s1=Source.fromURL("http://www.baidu.com","UTF-8").getLines;
    s1.foreach(line=>println(line+'\n'));
  }
}