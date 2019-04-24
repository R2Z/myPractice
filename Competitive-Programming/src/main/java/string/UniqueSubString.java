package string;

public class UniqueSubString {
	
	public static void main(String[] args) {
		
		String str[] = findSubSequence("1xyz");
		
		for (String string : str) {
			System.out.println(string);
		}
	}
	private static String[] findSubSequence(String str){
		
		String ans[] = {""};
		
		if(str.length() > 0){
			
			String subSeq[] = findSubSequence(str.substring(1));
			
			ans = new String[2*subSeq.length];
			
			int i;
			for(i =0 ; i < subSeq.length; i++){
				ans[i] = subSeq[i];
			}
			
			for(int j =0 ; j < subSeq.length; j++){
				ans[i+j] = str.charAt(0)+ subSeq[j];
			}
		}
		
		return ans;
		
	}

}
