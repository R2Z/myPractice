package array;

import java.util.HashMap;
import java.util.Map;

public class ArrayWithIndexValue {
	
	public static void main(String[] args) {
		
		int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		Object obj = new Object();
		Map<Integer , Object> map = new HashMap<Integer , Object>();
		for (int i =0;i< arr.length ;i++){
			map.put(arr[i], obj);
		}
		
		for (int i =0;i< arr.length ;i++){
			if(map.containsKey(i)){
				arr[i]=i;
			}else{
				arr[i]=-1;
			}
		}
		
		for (int i =0;i< arr.length ;i++){
			System.out.print(" " + arr[i]);
		}
	}

}
