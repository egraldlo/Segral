package actor

//最基本的scala库中的actor
import scala.actors.Actor._
import scala.actors.Actor
//scala.actors.Actor 和 scala.actors.Actor._不一样，都要有

//这里我们可以申明class为case的
case class Message(message: String,author: Int){}

class basicActorTest extends Actor{
  //下面有类似与JAVA中的run函数的act函数
  def act(){
    while(true){
      receive {
        case "Hi"=>println("A: hello, class!");
        //1, case中可以是个类
        //2, case中的类申明的时候必须是case class 
        case Message(message,author)=>println("A: "+message+"---I am "+author+" years old!");
        case "reply"=>{
          println("A: I have received the message and I will reply!");
          sender! "ok!"
          }
      }
    }
  }
}


object basicActorTest{
  def main(args:Array[String]){
    //-----------create a actor------------
    //1, 可以定义一个类的方式来使用actor
    //2, 可以定义一个方法来使用actor
    val basic1=new basicActorTest();
    basic1.start
    
    val basic2=actor {
      while(true){
        receive{
          case "HI"=>println("A: hello, method!");
        }
      }
    }
    
    val basic3=actor {
      loop{
        react{
          case "1"=>println("1");
          case "2"=>println("02");
        }
      }
    }
    
    val basic4=actor {
      react{
        case "1"=>println("1");
        case "2"=>println("2");
      }
    }
    
    //------------send message to actor--------------
    basic1 ! "Hi";
    basic2 ! "HI";    
    basic1 ! Message("helloworld", 24);
    
    //下面我们将要使用一些同步风格，但是同步模式的话有时候会发生死锁，所以最好不要
    val r=basic1!?"reply";//!?为等待actor的回复消息
    r match{
      case "ok!"=>println("B: I receive the message!");
    }
    
    basic4 ! "1";
    basic4 ! "2";
    
    basic3 ! "2";
    basic3 ! "2";

  }
}
