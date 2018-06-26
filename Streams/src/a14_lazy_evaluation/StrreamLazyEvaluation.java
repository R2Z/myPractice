package a14_lazy_evaluation;

import java.util.*;

public class StrreamLazyEvaluation {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    
    //given an ordered list find the double of the first even number greater than 3.
    
    int result = 0;
    for(int e : numbers) {
      if(e > 3 && e % 2 == 0) {
        result = e * 2;
        break;
      }
    }
    System.out.println(result);
    //how much work? 8 units work
    
    System.out.println(
      numbers.stream() //  vv
             .filter(StrreamLazyEvaluation::isGT3)
             .filter(StrreamLazyEvaluation::isEven)
             .map(StrreamLazyEvaluation::doubleIt)
             .findFirst().get());
  }
  public static boolean isGT3(int number) {
    System.out.println("isGT3 " + number);
    return number > 3;
  }
  public static boolean isEven(int number) {
    System.out.println("isEven " + number);
    return number % 2 == 0;
  }
  public static int doubleIt(int number) {
    System.out.println("doubleIt " + number);
    return number * 2;
  }
}