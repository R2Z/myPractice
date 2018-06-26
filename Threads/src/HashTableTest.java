import java.util.Hashtable;

public class HashTableTest {
	
	public static void main(String[] args) {
		
		String str = "test";
		Hashtable<String, String> ht = new Hashtable<String,String>();
		//ht.put(str, str);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(!ht.containsKey(str)){
					ht.put(str, str+"1");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(!ht.containsKey(str)){
					ht.put(str, str+"2");
				}
			}
		}).start();
		
		System.out.println(ht.toString());
	}
}
