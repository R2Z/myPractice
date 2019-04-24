package array1D;

public class ArrayPartitioning {

	public static void main(String[] args) {

		int arr[] = { 3, 1, 5, 9, 12 };
		if (findPartition(arr,arr.length)) {
			System.out.println("Array Partition possible");
		} else {
			System.out.println("Array Partition Not possible");
		}
	}

	private static boolean partitioneArra(int arr[]) {

		boolean bool = true;
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}

		if (sum % 2 != 0) {
			bool = false;
		} else {
			bool = subPartition(arr, arr.length, sum / 2);
		}

		return bool;
	}

	private static boolean subPartition(int arr[], int n, int sum) {

		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		if (arr[n - 1] > sum)
			return subPartition(arr, n - 1, sum);

		return subPartition(arr, n - 1, sum)
				|| subPartition(arr, n - 1, sum - arr[n - 1]);

	}
	
	static boolean findPartition (int arr[], int n)
    {
        int sum = 0;
        int i, j;
 
        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];
 
        if (sum%2 != 0)
            return false;
 
        boolean part[][]=new boolean[sum/2+1][n+1];
 
        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;
 
        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;
 
        // Fill the partition table in botton up manner
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] ||
                                 part[i - arr[j-1]][j-1];
                // TV = TV excluding new value || TV by excluding new Value
            }
        }
 
        /* // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++)
                printf ("%4d", part[i][j]);
            printf("\n");
        } */
 
        return part[sum/2][n];
    }
}
