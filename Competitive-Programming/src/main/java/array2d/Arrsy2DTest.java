package array2d;

import java.util.Scanner;

public class Arrsy2DTest {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][]arr = new int[row][col];
		for(int i =0;i<row;i++){
			for(int j =0;j<col;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		
		int []rowX = new int[col];
		
		for(int i =0;i<col;i++){
			rowX[i]=1;
		}
		
		
		for(int i =0;i<row;i++){
			for(int j =0;j<col;j++){
				if(arr[i][j]==1){
					arr[i]=rowX;
					break;
				}
			}
		}
		
		
		for(int i =0;i<row;i++){
			for(int j =0;j<col;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
