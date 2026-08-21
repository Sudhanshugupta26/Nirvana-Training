package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {
     public static void main(String[] args) {

       // Parallel Stream takes less time than Normal Stream for large data sets and more if small computation happening for each traverse.
       List<Integer> numbers = IntStream.rangeClosed(1, 100000)
                                         .boxed()
                                         .collect(Collectors.toList());
       long startTime;
       long endTime;

       startTime = System.currentTimeMillis();

       numbers.parallelStream()
              .forEach(n-> {System.out.println(n*n);});

       endTime = System.currentTimeMillis();

       System.out.println("Parallel Stream Time: "+ (endTime - startTime) + " ms");

       long lstartTime = System.currentTimeMillis();

        numbers.stream()
               .forEach(n -> { System.out.println(n*n); });

       long lendTime = System.currentTimeMillis();

       System.out.println("Stream Time: "+ (lendTime - lstartTime) + " ms");
       System.out.println("ParallelStream Time: "+ (endTime - startTime) + " ms");
       }
}
