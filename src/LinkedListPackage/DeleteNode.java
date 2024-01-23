package LinkedListPackage;

import java.util.Scanner;

public class DeleteNode {

    public static Node<Integer> deleteNode( Node<Integer> head, int pos) {
        // Write your code here.

        if(pos == 0) {
            head = head.next;
            return head;
        }
        int count = 0;
        Node <Integer> prev = head;

        while(count < pos -1) {
            count++;
            if(prev != null) {
                prev = prev.next;

            }
        }
        if(prev == null) {
            return head;
        }
        if(prev.next == null) {
            return head;
        }else{
            prev.next = prev.next.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node<Integer> head = LinkedListIInputDynamic.takeInput();
        System.out.print("Pos to delete = " );
        int pos = sc.nextInt();
        Node<Integer> deletedOutput = deleteNode(head,pos);
        LinkedListIInputDynamic.printLL(deletedOutput);

    }



}
