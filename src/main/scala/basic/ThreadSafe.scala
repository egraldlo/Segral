package basic

//problem definiton:这个类无法保证线程安全
//在java中有三种方式：
//mutex
//volatile
//AtomicReference

class Person0(var name:String){
  def set(changedName:String){
    name=changedName;
  }
}

class Person1(var name: String) {
  def set(changedName: String) {
    this.synchronized {
      name = changedName
    }
  }
}

class Person2(@volatile var name: String) {
  def set(changedName: String) {
    name = changedName
  }
}

import java.util.concurrent.atomic.AtomicReference

class Person3(val name: AtomicReference[String]) {
  def set(changedName: String) {
    name.set(changedName)
  }
}

class ThreadSafe {
	
}