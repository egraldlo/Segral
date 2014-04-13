package inaction

/*
 * <:为定义上界，不能超过上界
 * */
class Pair1[T<:Comparable[T]](val first:T,val second:T){
  def smaller=if (first.compareTo(second)<0) first else second;
}

/*
 * 为定义上界的情况下，可以使用视图界定，<%意味着可以被隐式转换
 * 视图界定要求必须存在一个从T到Comparable[T]的隐式转换
 * */
class Pair2[T<%Comparable[T]](val first:T,val second:T){
  def smaller=if (first.compareTo(second)<0) first else second;
}

object gerTest {
  def main(args:Array[String]){
    val pair1=new Pair1("sting","cdcd")
    println(pair1.smaller)
    val pair2=new Pair2(2,4)
    println(pair2.smaller)
  }
}