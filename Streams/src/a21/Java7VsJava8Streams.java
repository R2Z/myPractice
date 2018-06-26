package a21;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java7VsJava8Streams {

	private static int sumOfEven(List<Integer> numbers) {
		int result = 0;

		for (int e : numbers) {
			if (e % 2 == 0) {
				result += e * 2;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Predicate<Integer> evenNum = e -> e % 2 == 0;
		Predicate<Integer> oddNum = e -> e % 2 != 0;
		Predicate<Integer> allNum = e -> e % e == 0;
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//System.out.println(sumOfEven(numbers));
		
		System.out.println(sumOfNumbers(numbers, allNum));
		//System.out.println(numbers.stream().filter(evenNum).mapToInt(e -> e * 2).sum());
		

	}
	
	private static int sumOfNumbers(List<Integer> numbers,Predicate<Integer> condition) {
		int result = 0;

		for (int e : numbers) {
			if (condition.test(e)) {
				result += e * 2;
			}
		}
		return result;
	}
}