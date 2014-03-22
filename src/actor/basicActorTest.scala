package actor

//this is the basic actor mode supporting in Scala lib
import scala.actors.Actor

class basicActorTest extends Actor{
  def act(){
    while(true){
      receive {
        case "Hi"=>println("hello");
      }
    }
  }
}

object basicActorTest{
  def main(args:Array[String]){
    val basic=new basicActorTest();
    basic.start
  }
}
