package ArrayListPackage;

import java.util.ArrayList;

public class ArrayListPractice {

    public static void main(String [] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(5);
        arr.add(44);
        arr.add(1,4);
        System.out.println(arr.get(1));

    }
}
