package StackPackage;

public class StackUsingArray {

   private int [] data;
    private int topIndex;

    public StackUsingArray() {
        data = new int [1];
        topIndex = -1;

    }

    public void DoubleCapacity() {

        int temp [] = data;
        data =  new int [2 * temp.length];

        for(int i = 0; i < temp.length; i++) {
            data [i] = temp [i];
        }
    }





    public void push(int element)  {

        if(topIndex == data.length -1) {
//            throws stackEmptyException
//            StackFullException e = new StackFullException();
//            throw e;
            DoubleCapacity();
        }
        data[++topIndex] = element;



    }

    public int top() {

        if(topIndex == -1) {
//            throw new StackEmptyException();
        }
        return data[topIndex];
    }

    public int pop() throws StackEmptyException {
        if(topIndex == -1) {
            throw new StackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;

    }

    public int size() {
        return topIndex + 1;

    }

    public boolean isEmpty() {
        return topIndex == -1;

    }
}
