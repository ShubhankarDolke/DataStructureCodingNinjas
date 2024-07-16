package RecursionHardProb;

public class FactorialUpDownAndDownUp {

//    recursive call with small prob down to up
    public static int factorialHelper (int n) {
        if(n == 0) {
            return 1;

        }

        return n * factorialHelper(n -1);

    }

    public static void factorial(int n ){

        int out = factorialHelper(5);
        System.out.println(out);

    }

//    recursive call with up to down rec call

    public static void factorial2(int input , int answer) {
        if(input == 0) {
            System.out.println(answer);
            return;
        }

        answer = answer * input;

        factorial2(input -1, answer);
    }


    public static void main(String[] args) {

//        System.out.println(factorial(5));
//        factorial(5);

        factorial2(5, 1);
    }
}
