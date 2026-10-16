package JavaCourse;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class ParallelStream {
    private static final Logger LOGGER = Logger.getLogger(ParallelStream.class.getName());

    public static void main(String[] args) {
        // Parallel streams are faster for large data sets with heavier per-element work.
        List<Integer> numbers = IntStream.rangeClosed(1, 100_000)
                .boxed()
                .toList();

        long parallelStartTime = System.currentTimeMillis();
        int parallelSum = numbers.parallelStream()
                .mapToInt(n -> n * n)
                .sum();
        long parallelEndTime = System.currentTimeMillis();

        long normalStartTime = System.currentTimeMillis();
        int normalSum = numbers.stream()
                .mapToInt(n -> n * n)
                .sum();
        long normalEndTime = System.currentTimeMillis();

        LOGGER.info(() -> "Parallel Stream Time: " + (parallelEndTime - parallelStartTime) + " ms");
        LOGGER.info(() -> "Normal Stream Time: " + (normalEndTime - normalStartTime) + " ms");
        LOGGER.info(() -> "Parallel Sum: " + parallelSum);
        LOGGER.info(() -> "Normal Sum: " + normalSum);
    }
}
