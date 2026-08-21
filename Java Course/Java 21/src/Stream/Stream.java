package Stream;

import java.util.*;
import java.util.stream.*;

public class Stream {

    public static void main(String[] args) {

        // Normal Stream takes less time than Parallel Stream for small data sets and more if large computation happening for each traverse.

        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();

        numbers.stream()
               .forEach(n -> { n = n*n ;});

        endTime = System.currentTimeMillis();

        System.out.println("Stream Time: "+ (endTime - startTime) + " ms");

    }
}