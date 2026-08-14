package JavaBasics;

import java.util.*;
import java.util.function.*;

public class Q7Lambda{

    // Functional interface
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    public static void main(String[] args) {

        // ------------------------------------------------
        // 1. Lambda with no parameters
        // ------------------------------------------------

        Runnable r = () -> System.out.println("Hello from Lambda!");

        r.run();


        // ------------------------------------------------
        // 2. Lambda with one parameter
        // ------------------------------------------------

        Consumer<String> printName =
                name -> System.out.println("Name: " + name);

        printName.accept("Sudhanshu");


        // ------------------------------------------------
        // 3. Lambda with multiple parameters
        // ------------------------------------------------

        Calculator addition =
                (a, b) -> a + b;

        System.out.println("Addition: "
                + addition.calculate(10, 20));


        // ------------------------------------------------
        // 4. Lambda with multiple statements
        // ------------------------------------------------

        Calculator multiplication = (a, b) -> {

            int result = a * b;

            return result;
        };

        System.out.println("Multiplication: "
                + multiplication.calculate(10, 20));


        // ------------------------------------------------
        // 5. Lambda with Predicate
        // ------------------------------------------------

        Predicate<Integer> isEven =
                n -> n % 2 == 0;

        System.out.println("Is 10 even? "
                + isEven.test(10));

        System.out.println("Is 15 even? "
                + isEven.test(15));


        // ------------------------------------------------
        // 6. Lambda with Function
        // ------------------------------------------------

        Function<Integer, Integer> square =
                n -> n * n;

        System.out.println("Square: "
                + square.apply(5));


        // ------------------------------------------------
        // 7. Lambda with Supplier
        // ------------------------------------------------

        Supplier<Double> randomNumber =
                () -> Math.random();

        System.out.println("Random number: "
                + randomNumber.get());


        // ------------------------------------------------
        // 8. Lambda with List.forEach()
        // ------------------------------------------------

        List<Integer> numbers =
                new ArrayList<>(
                        Arrays.asList(10, 20, 30, 40, 50)
                );

        System.out.println("Numbers:");

        numbers.forEach(
                n -> System.out.println(n)
        );


        // ------------------------------------------------
        // 9. Lambda with removeIf()
        // ------------------------------------------------

        numbers.removeIf(
                n -> n > 30
        );

        System.out.println("After removing > 30:");

        numbers.forEach(
                n -> System.out.println(n)
        );


        // ------------------------------------------------
        // 10. Lambda with Comparator
        // ------------------------------------------------

        List<Integer> nums =
                new ArrayList<>(
                        Arrays.asList(50, 10, 40, 20, 30)
                );

        nums.sort(
                (a, b) -> a - b
        );

        System.out.println("Sorted:");

        nums.forEach(
                n -> System.out.print(n + " ")
        );
    }
}