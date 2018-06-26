package a05_function_composition;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java7VsJava8Streams {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //given the values, double the even numbers and total.
    
    /*int result = 0;
    
    for(int e : numbers) {
      if(e % 2 == 0) {
        result += e * 2;
      }
    }
    
    System.out.println(result);*/
    Predicate<Integer> evenNum = e -> e % 2 == 0;
    Function<Integer, Integer> sum = e -> e * 2;
    System.out.println(
      numbers.stream()
             .filter(evenNum)
             .mapToInt(e -> e * 2)
             .sum());
    
  }
}