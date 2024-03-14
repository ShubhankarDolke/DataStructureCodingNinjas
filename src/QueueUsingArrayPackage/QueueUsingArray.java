package QueueUsingArrayPackage;

public class QueueUsingArray {


    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        data = new int[10];
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

        if (front == -1) {
            data[0] = element;
            front = 0;
            rear = 0;


        }
        data[rear] = element;
        rear++;
        size++;


    }

    int dequeue() {

        if (size == 0) {
            System.out.print("Empty Queue");
            return -1;
        }

        int temp = data[front];

        front++;
        size--;

        return temp;


    }

    int print(int index) {
        return data[index];
    }


}
