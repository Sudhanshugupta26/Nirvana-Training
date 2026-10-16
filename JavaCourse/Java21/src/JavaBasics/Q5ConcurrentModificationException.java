package JavaBasics;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Q5ConcurrentModificationException {

    // 1. Generate ConcurrentModificationException
    static void generateException() {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        try {
            for (Integer num : numbers) {

                if (num == 20) {
                    numbers.remove(0);   // Causes exception
                }

                System.out.println(num);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception handled: "
                    + e.getClass().getSimpleName());
        }
    }

    // 2. Handle it using Iterator
    static void handleUsingIterator() {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {

            Integer num = iterator.next();

            if (num == 20) {
                iterator.remove();
            }
            System.out.print(num+", ");
        }
        System.out.println();   
    }

    // 3. Handle it using removeIf()
    static void handleUsingRemoveIf() {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        numbers.removeIf(num -> num == 20);

        System.out.println("Using removeIf(): " + numbers);
    }

    // 4. Handle it by creating a separate list
    static void handleUsingSeparateList() {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        List<Integer> toRemove = new ArrayList<>();

        for (Integer num : numbers) {

            if (num == 20) {
                toRemove.add(num);
            }
        }

        numbers.removeAll(toRemove);

        System.out.println("Using separate list: " + numbers);
    }

    public static void main(String[] args) {

        System.out.println("1. Generating Exception");
        generateException();

        System.out.println("\n2. Using Iterator");
        handleUsingIterator();

        System.out.println("\n3. Using removeIf()");
        handleUsingRemoveIf();

        System.out.println("\n4. Using Separate List");
        handleUsingSeparateList();
    }
}