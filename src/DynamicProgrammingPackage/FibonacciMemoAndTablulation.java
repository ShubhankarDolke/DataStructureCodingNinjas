package DynamicProgrammingPackage;

import java.util.*;
import java.util.Scanner;

//recursion
//memoization
//tabulation


public class FibonacciMemoAndTablulation {

    static ArrayList<Integer> dp;

    //    tabulation
    public static int fibTabulation(int n) {
        dp.set(0, 0);
//        if(n >= 1) {
            dp.set(1, 1);
//        }


        for(int i = 2; i <= n; i++) {
            dp.set(i , dp.get(i - 1) + dp.get(i - 2));
        }
        return dp.get(n);
    }



    //    memoization
    public static int fibMemo(int n) {

        if(n <= 1) {
//            dp.set(n , n);
            return n;
        }
        if(dp.get(n) != -1) {
            return dp.get(n);
        }

        int temp = fibMemo(n - 1) + fibMemo(n - 2);
        dp.set(n , temp);
        return temp;
    }


//    recursion

    private static int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n -2);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

//        System.out.println(fib(n));
        dp = new ArrayList<>();
//        dp = new ArrayList<>(Collections.nCopies(n + 1, -1));

        for(int i = 0; i <= n; i++) {
            dp.add(-1);
        }

//        int output = fibMemo(n);
        int output = fibTabulation(n);
        System.out.println(output);





    }
}
