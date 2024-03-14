package StackPackage;


import LinkedListPackage.Node;

public class StackUsingLinkedList <T>{
    private Node<T>  head;
    private int size;

    public StackUsingLinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void push(T element) {

        Node<T> nodeToBeAdded = new Node<>(element);
        nodeToBeAdded.next = head;
        head = nodeToBeAdded;
        size++;
    }

    public T pop() {
        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.data;


    }

    public T top() {
        return head.data;

    }






}
