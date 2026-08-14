package JavaBasics;

public class Q9MaxAndMinArray {
    public static void main(String[] args) {
        int[] arr = {
    -5, 3, -3, 5, 0, -1, 1, -2, 2,
    -10, 10, -20, 20, -30, 30,
    100, -100, 99, -99, 50, -50,
    7, -7, 7, -7, 0, 0,
    42, -42, 41, -41, 1, -1,
    -8, 8, -9, 9, -4, 4,
    -1000, 1000, -500, 500,
    25, -25, 75, -75, 125, -125
};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (min>i) {
                min = i;
            }
            if (max<i) {
                max = i;     
            }
        }
        System.out.println("Max is: "+max+"\nMin is: "+min);
    }
}
