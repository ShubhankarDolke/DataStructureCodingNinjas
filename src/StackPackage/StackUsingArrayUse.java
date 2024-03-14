package StackPackage;

public class StackUsingArrayUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {

        StackUsingArray stack = new StackUsingArray();

        int arr [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        for(int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }


//
//        System.out.println(stack.top());
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
//
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());



    }
}
