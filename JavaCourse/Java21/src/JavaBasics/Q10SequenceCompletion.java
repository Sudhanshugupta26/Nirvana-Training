package JavaBasics;

public class Q10SequenceCompletion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8};

        int start = arr[0];
        int end = arr[arr.length - 1];

        int n = arr.length + 1;

        int expectedSum = (start + end) * n / 2;

        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        int missing = expectedSum - actualSum;

        System.out.println("Missing number: " + missing);
    }
}
