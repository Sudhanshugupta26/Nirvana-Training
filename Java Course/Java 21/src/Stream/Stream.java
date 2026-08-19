package Stream;

import java.util.*;
import java.util.stream.*;

public class Stream {

    public static void main(String[] args) {

        // Create list from 1 to 1,000,000
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());
        long startTime;
        long endTime;
        // =========================
        // Sequential Stream
        // =========================



        startTime = System.currentTimeMillis();

        numbers.stream()
               .forEach(n -> {});

        endTime = System.currentTimeMillis();

        System.out.println("Stream Time: "
                + (endTime - startTime) + " ms");

    }
}