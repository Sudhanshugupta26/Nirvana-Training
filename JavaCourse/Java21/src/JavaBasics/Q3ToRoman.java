package JavaBasics;

import java.util.Scanner;

public class Q3ToRoman {

    public static String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number smaller than 4000: ");
        int number = sc.nextInt();
        if (number < 1 || number >= 4000) {
            System.out.println("Invalid input. Please enter a number between 1 and 3999.");
            return;
        }

        String roman = intToRoman(number);

        System.out.println("Number: " + number);
        System.out.println("Roman: " + roman);
    }
}
