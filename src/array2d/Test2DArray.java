package array2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2DArray {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String arr[] = str1.split(" ");
		int noRows = Integer.parseInt(arr[0]);
		int noCols = Integer.parseInt(arr[1]);
		String rowStr[] = new String[noRows];
		for(int i =0;i<noRows;i++){
			rowStr[i]=br.readLine();
		}
		
		/*for (String string : rowStr) {
			System.out.println(string);
		}*/
		
		int arrInt[][] = new int [noRows][noCols];
		for(int i=0;i<noRows;i++){
			String st[] = rowStr[i].split(" ");
			for(int j=0;j<noCols;j++){
				arrInt[i][j]= Integer.parseInt(st[j]);
			}
		}
		
		//System.out.println("-------------------------------------------------");
		reverseArray(arrInt, noRows, noCols);
	}

	private static void reverseArray(int arrInt[][] , int row,int col){
		
		int arr2[][] = new int[col][row];
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				arr2[j][i]=arrInt[i][j];
			}
		}
		
		printArr(arr2, col, row);
	}
	
	private static void printArr(int arrInt[][] , int row,int col){
		
		String rowStr = "";
		for(int i=0;i<row;i++){
			if(rowStr!=""){
				System.out.println(rowStr);
			}
			rowStr = "";
			for(int j=0;j<col;j++){
				if(rowStr!=""){
					rowStr += " ";
				}
				rowStr +=arrInt[i][j]+" ";
			}
		}
		if(rowStr!=""){
			System.out.println(rowStr);
		}
	}
}
