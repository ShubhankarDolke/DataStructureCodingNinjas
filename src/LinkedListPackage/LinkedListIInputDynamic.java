//O(n2)
package LinkedListPackage;

import java.util.*;


public class LinkedListIInputDynamic {


    public static Node<Integer> takeInput() {
        Node<Integer> head = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if (head == null) {
                head = currentNode;
            } else {
                Node<Integer> tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = currentNode;
            }
            data = sc.nextInt();
        }
        return head;

    }

    public static void printLL(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printLL(head);


    }


}



