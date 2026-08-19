package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {
     public static void main(String[] args) {

        // Create list from 1 to 1,000,000
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();

        numbers.parallelStream()
               .forEach(n->{});

        endTime = System.currentTimeMillis();

        System.out.println("Parallel Stream Time: "
                + (endTime - startTime) + " ms");
    }
}
