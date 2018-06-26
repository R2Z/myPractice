package a01_high_ceremony;

import java.util.stream.IntStream;

public class Java7VsJava8Lambdas {
  public static void main(String[] args) {
     
	  //java7Func();
	  java8Func();
	  System.out.println("In main");
  }
  
  private static void java7Func(){
	  
	  for(int i = 0; i<5;i++){
		  final int x = i;
		  new Thread(new Runnable() {
		      public void run() {
		        System.out.println("Thread " + x);
		      }
		    }).start();
	  }
  }
  
private static void java8Func(){
	IntStream.range(0,5).forEach(num -> new Thread(()-> System.out.println(Thread.currentThread().getName() +" " + num)).start());
}
}