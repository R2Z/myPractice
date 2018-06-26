package a06_parallel_stream;

import java.util.Arrays;
import java.util.List;

public class StreamRunningParral {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","5");
		System.out.println(
				// numbers.stream().filter(e -> e % 2 != 0).mapToInt(Sample::compute).sum());
				numbers.parallelStream().filter(e -> e % 2 != 0).mapToInt(StreamRunningParral::compute).sum());
	}

	public static int compute(int number) {
		try {
			System.out.println("number " + number + " "+ Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (Exception ex) {
		}
		return number * 2;
	}
}