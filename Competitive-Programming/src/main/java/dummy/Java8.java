package dummy;

public class Java8 implements Test{
	
	
	public static void main(String[] args) {
		
		Java8 j = new Java8();
		j.myDefault();
		
		Test.staticMethod();
		
	}

	@Override
	public void testFunc() {
		// TODO Auto-generated method stub
		
	}

}

 @FunctionalInterface
 interface Test{
	 
	 void testFunc();
	 
	 public default void myDefault(){
		 System.out.println("myDefault");
		 
	 }
	 
	 public static void staticMethod(){
		 System.out.println("staticMethod");
	 }
	 
	 @Override
	String toString();
	 
	@Override
	int hashCode(); 
}

 
