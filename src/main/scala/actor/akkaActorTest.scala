package main.scala.actor

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class akkaActorTest extends Actor{
  def receive = {
    case "hi" => println("cdcd");
  }
}

object akkaActorTest{
  def main(args:Array[String]){
    val system=ActorSystem("mySystem");
    val myactor=system.actorOf(Props[akkaActorTest], name="akkaTest")    
    val message="hi";
    myactor ! message;
  }
}