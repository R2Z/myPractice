package bit;

public class SetBitTest {

	public static void main(String[] args) {
		int n = 254;
		System.out.println("countSetBits "+countSetBits(n));
		System.out.println("coutBK "+coutSetBK(n));
		System.out.println("countLookUp "+countSetLookUp(n));
		System.out.println("convertAToB "+convertAToB(n,100));
	}
	
	private static int convertAToB(int a, int b){
		
		int count = countSetLookUp(a^b);
		
		return count;
	}
	private static int countSetBits(int n){
		
		int count = 0;
		while(n!=0)
		  {
		    count += n & 1;
		    n >>= 1;
		  }
		return count;
	}
	
	private static int coutSetBK(int n){
		int 	count = 0;
		
		while(n !=0 ){			
			n &=(n-1);
			count++;
		}
		
		return count;
	}
	
	private static int countSetLookUp(int n){
		int count = 0;
		int table[] = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4};
		while(n !=0){
			count+= table[n & 0xF];
			n=n>>4;
		}
		return count;
	}
}
