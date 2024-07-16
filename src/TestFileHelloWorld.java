
import java.util.*;

class TestFileHelloWorld {

    public static void merge(int [] s1, int [] s2, int [] d) {

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < s1.length && j < s2.length) {

            if(s1[i] <= s2[j]) {
                d[k] = s1[i];
                i++;
                k++;
            }else{
                d[k] = s2[j];
                k++;
                j++;

            }
        }
        while(i < s1.length) {
            d[k] = s1[i];
            i++;
            k++;
        }

        while(j < s2.length) {
            d[k] = s2[j];
            j++;
            k++;
        }
    }


    public static void mergeSort(int [] arr) {
// split the array into two small array
        if(arr.length <= 1) {
            return;
        }
//        1     2      3      4

        int [] s1 = new int[arr.length /2];

        int [] s2 = new int [arr.length - s1.length];

        for(int i = 0; i < arr.length / 2; i++){
            s1[i] = arr[i];
        }

        for(int i = arr.length /2; i < arr.length; i++) {
            s2 [i - arr.length /2] = arr[i];
        }

        mergeSort(s1);
        mergeSort(s2);
        merge(s1, s2, arr);


    }
    public static void main (String[] args) {

        int [] arr = {6,4,5,2,   2,78,9,7, 9, 6};
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }



    }
}
