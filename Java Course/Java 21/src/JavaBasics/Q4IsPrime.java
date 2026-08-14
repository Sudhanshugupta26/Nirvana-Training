package JavaBasics;

import java.util.Scanner;

public class Q4IsPrime {
    static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        for(int i=2; i<=num; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
        
    }   
}
