package stsck;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishProblem {
	
	public static void main(String[] args) {
		
		String str = "512+4*+3-";
		System.out.println(doCalculation(str));
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private static int doCalculation(String str){
		int x,y;
		int result = 0;
		Character arr[] = {'+','-','*','/'};
		List<Character> oprList = Arrays.asList(arr);
		Stack<Integer> stk = new Stack();
		for(int i =0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(oprList.contains(ch)){
				y=stk.pop();
				x=stk.pop();
				result = doMath(x, y, ch);
				stk.push(result);
			}else{
				stk.push(Integer.valueOf(""+ch));
			}
		}
		return stk.pop();
	}
	
	private static int doMath(int x, int y , char op){
		
		int result = 0;
		if(op == '+'){
			result = x+y;
		}else if (op == '-'){
			result = x-y;
		}else if (op == '*'){
			result = x*y;
		}else if (op == '/'){
			result = x/y;
		}
		return result;
		
	}

}
