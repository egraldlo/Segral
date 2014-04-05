package basic

import java.net.{Socket,ServerSocket}
import java.util.concurrent.{Executors, ExecutorService}
import java.util.Date

class Threads {
  val hello=new Thread(new Runnable{
    def run(){
      print("in the thread\n")
    }
  })
  hello.start()
}

class threadTest extends Runnable{
  override def run(){
    print("in the threadtest\n")
  }
}

class Handler(socket: Socket) extends Runnable{
  def message=(Thread.currentThread().getName()+"\n").getBytes()
  def run(){
    //将这个线程中接收的信息打印
    socket.getOutputStream.write(message)
    //往这个流中写东西
    socket.getOutputStream.close()
  }
}

class NetworkService(port:Int,poolsize:Int) extends Runnable{
  val serverSocket=new ServerSocket(port)
  
  def run(){
    while(true){
      /*接受一个链接，服务器段返回一个端口的映射*/
      val socket=serverSocket.accept()
      //如果是现在下面这种情况，是在一个main线程实例化一个实例来run
//      (new Handler(socket)).run()
      //如果是现在下面这种情况，是收到一个链接之后，新建一个线程
      (new Thread(new Handler(socket))).start()
    }
  }
}

//下面是相对于NetworkService更抽象的接口
class NetworkServiceExecutor(port:Int, poolsize:Int) extends Runnable{
  val serverSocket=new ServerSocket(port)
  val pool:ExecutorService=Executors.newFixedThreadPool(poolsize)
  
  def run(){
    while(true){
      val socket=serverSocket.accept()
      pool.execute(new Handler(socket))
    }
  }
}

object Threads{
  def main(args:Array[String])={
    //新建线程
    val ths=new Threads
    //新建线程
    val th=new threadTest
    th.run
    //新建网络服务
//    (new NetworkService(2050,2)).run
    //用executor更加抽象的线程模型
    (new NetworkServiceExecutor(2030,1)).run
    
  }
}


