
package LinkedListPackage;
import java.util.*;
public class LinkedListUse {

    public static Node<Integer> createLinkedList() {
        Node <Integer> n1= new Node<>(10);
        Node<Integer> n2= new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

//
//        System.out.println("n1" + "Data = " +n1.data +  " next = " + n1.next);
//
//        System.out.println("n2" + "Data = " +n2.data +  " next = " + n2.next);
//
//        System.out.println("n3" + "Data = " +n3.data +  " next = " + n3.next);
//
//        System.out.println("n4" + "Data = " +n4.data +  " next = " + n4.next);
        return n1;
    }

    public static void printLinkedList(Node<Integer> head) {

        Node<Integer> temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
//        temp = head;
//
//        while(temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//
//        }
//        System.out.println();
//        System.out.println("head =" + head.data +  " " + head.next);
//        System.out.println("n2 =" + head.next.data +  " " + head.next.next);
//        System.out.println("n3 =" + head.next.next.data +  " " + head.next.next.next);
//        System.out.println("n4 =" + head.next.next.next.data +  " " + head.next.next.next.next);


    }


    public static Node<Integer> takeInput() {

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;

        while(data != -1) {

            Node<Integer> currentNode = new Node<>(data);

            if(head == null) {
                head = currentNode;

            }else{
                Node<Integer> tail = head;
                while(tail.next != null) {
                    tail = tail.next;

                }
                tail.next = currentNode;

            }
            data = sc.nextInt();

        }


        return head;
    }

    public static void main(String[] args) {


       Node <Integer> head = takeInput();

       //createLinkedList();
//        System.out.println(head.data +  " " + head.next);
//        printLinkedList(head);
        printLinkedList(head);
    }
}
