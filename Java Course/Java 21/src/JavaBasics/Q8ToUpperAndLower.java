package JavaBasics;

import java.util.Scanner;

public class Q8ToUpperAndLower{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // z = 122
        // A = 65
        // a=97
        // Z = 90
        // ToUpper(s);
        // ToLower(s);
        System.out.println(toUpper(s));
        System.out.println(toLower(s));
    }

    private static String toLower(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c==' ') {
                ans.append(' ');
            }else if (64 < c && c <91) {
                int newChar = c + 32;
                ans.append((char)newChar);
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }

    private static String toUpper(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c==' ') {
                ans.append(' ');
            }else if (96 < c && c < 123) {
                int newChar = c - 32;
                ans.append((char)newChar);
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}