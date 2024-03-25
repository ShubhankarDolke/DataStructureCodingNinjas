package QueueUsingLinkedListPackage;

import LinkedListPackage.Node;

public class QueueUsingLinkedList <T> {

    private Node <T> front;
    private Node <T> rear;

    private int size;


    public QueueUsingLinkedList () {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;


    }
    public boolean isEmpty() {

        return size == 0;


    }

    public void enqueue(T element) {
        Node <T> newNode = new Node<>(element);
        if(size == 0) {
            front = newNode;
            rear = newNode;
            size++;

        }else{
            rear.next = newNode;
            rear = newNode;
            size++;
        }

    }

    public T dequeue() {

        if(size == 0) {
            return null;
        }

        T temp = front.data;
        front = front.next;
        if(front == null) {
            rear = null;

        }
        size--;
        return temp;

    }

    public T front() {
        return front.data;

    }











}
