//O(n)
package LinkedListPackage;

import java.util.*;

public class LinkedListInputDynamicOptimized {

    public static Node<Integer> takeInputOpti() {
        Node<Integer> head = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> tail = null;
        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if (head == null) {
                head = currentNode;
                tail = currentNode;

            } else {
                tail.next = currentNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;

    }


    public static void main(String[] args) {
        Node<Integer> head = takeInputOpti();
        LinkedListIInputDynamic.printLL(head);

    }


}
