package stsck;

import java.util.Scanner;

public class StackProblems {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int noOfProblems = sc.nextInt();
		int i =0;
		Stack st = new Stack(noOfProblems-1);
		int rerquestType = -1;
		while(i++<noOfProblems){
			rerquestType=sc.nextInt();
			if(rerquestType == 1){
				if(st.isEmpty()){
					System.out.println("No Food");
				}else{
					System.out.println("Cost "+st.pop());
				}
			}else{
				int price = sc.nextInt();
				st.push(price);
			}
		}
	}
}
