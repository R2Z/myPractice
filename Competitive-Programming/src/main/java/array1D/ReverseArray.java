package array1D;

public class ReverseArray {
	  public static void main(String[] args) {
	    
	    int [] arr = {1,2,3,4,5,6,7,8};
	    int start = 0;
	    int end = arr.length-1;
	    
	    System.out.print(" Input ");
	    
	    for(Integer i : arr){
		      System.out.print(" "+i);
		    }
	    
	    while(start < end){
	    
	      swap(arr,start,end);
	      start ++;
	      end --;
	    
	    }
	    
	    System.out.print(" Output ");
	    
	    for(Integer i : arr){
	      System.out.print(" "+i);
	    }
	    
	  }
	  
	  private static void swap (int arr[] , int start , int end){
	  
	    int tmp = arr[start];
	    arr[start] = arr[end];
	    arr[end] = tmp;
	  
	  }
	}
