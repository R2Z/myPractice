package a17_changing_a_property_to_sorted;

import java.util.*;
import java.util.function.Predicate;

public class StreamSortings {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    Predicate<Integer> even = e -> e % 2 == 0;
    numbers.stream()
           .filter(even)
          // .sorted().distinct()
           .forEach(System.out::println);
    //sized, ordered, non-distinct, sorted
  }
}