package a02_just_the_essence;

public class Sample {
  public static void main(String[] args) {
//function has 4 things
//1. name - anonymous
      //2. parameter list
      //3. body
//4. return type - inferred


    new Thread(() -> System.out.println("In another thread")
    		).start();
    
    System.out.println("In main");
  }
}