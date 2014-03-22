package main.scala.common

abstract class Typer{
  val typeNo:Int
  def print()
}

class Schema(schema:Array[Typer]) {
	def print()={
		schema.foreach(column=>println(column.typeNo))
	}
}

class IntOperator extends Typer{
  val typeNo=0
  def print(){
    println(typeNo)
  }
}

class LongOperator extends Typer{
  val typeNo=1
  def print(){
    println(typeNo)
  }
}

object Schema{
  def main(args:Array[String])={
    val tv=new Array[Typer](2)
    tv(0)=new IntOperator
    tv(1)=new LongOperator
    val schema=new Schema(tv)
    tv.foreach(column=>column.print)
  }
}