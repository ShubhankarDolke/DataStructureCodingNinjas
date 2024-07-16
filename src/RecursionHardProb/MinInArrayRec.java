package RecursionHardProb;

public class MinInArrayRec {

    public static int minInArray(int [] arr, int startIdnex) {
        if(startIdnex == arr.length) {
            return Integer.MAX_VALUE;
        }
        int minSmallArray = minInArray(arr, startIdnex + 1);
        if(arr[startIdnex] < minSmallArray) {
            return arr[startIdnex];
        }else{
            return minSmallArray;
        }
    }


    public static void findMinInArrayVoid(int [] arr, int startIndex, int minSoFar) {
        if(startIndex == arr.length) {
            System.out.println(minSoFar);
            return;
        }

        int newMinimum = minSoFar;
        if(arr[startIndex] < minSoFar) {
            newMinimum = arr[startIndex];
        }

        findMinInArrayVoid(arr, startIndex + 1, newMinimum);
    }
    public static void main(String[] args) {

        int [] arr = {2,3,4,1,5,6,8,9};
//        int output = minInArray(arr, 0);
//        System.out.println(output);

        findMinInArrayVoid(arr, 0, Integer.MAX_VALUE);


    }
}
