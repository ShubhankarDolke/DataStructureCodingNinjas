package QueueUsingArrayPackage;

public class QueueUsingArray {


    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        data = new int[2];
        front = -1;
        rear = -1;


    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    int size() {
        return size;

    }

    boolean isEmpty() {
        return size == 0;

    }


    int front() {
        if (front == -1) {
            return -1;
        }

        return data[front];
    }

    void enqueue(int element) {
        if (size == data.length) {
            doubleCapacity();

        }

        if (size == 0) {
            front = 0;
        }
//        rear++;
//        if(rear == data.length) {
//            rear = 0;
//        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;


    }

    private void doubleCapacity() {

        int temp [] = data;
        data = new int [temp.length * 2];

        int index = 0;

        for (int i = front; i < temp.length; i++) {
            data[index++] = temp[i];

        }

        for (int i = 0; i < front; i++) {
            data[index++] = temp[i];

        }
        front = 0;
        rear = temp.length - 1;
    }

    int dequeue() {
        int temp = data[front];
//        front++;
//        if(front == data.length) {
//            front = 0;
//        }
        front = (front + 1) % data.length;
        size--;

        if (size == 0) {
//            System.out.print("Empty Queue");
            front = -1;
            rear = -1;
//            return -1;
        }
        return temp;




    }

//    int print(int index) {
//        return data[index];
//    }


}
