package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		 
		List<String> arr = new ArrayList<String>();
		 //output should be 6054854654
        /*arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");*/
        
        // output should be 777776
        /* arr.add("7");
        arr.add("776");
        arr.add("7");
        arr.add("7");*/
        
         
        //output should be 998764543431
        /*arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
        */
        printLargestNum(arr);
	}
	
	private static void printLargestNum(List<String> arr){
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String ab = a+b;
				String ba = b+a;
				return ab.compareTo(ba) > 0 ? -1:1;
			}
		});
		
		for (String string : arr) {
			System.out.print(string);
			
		}
	}
}
