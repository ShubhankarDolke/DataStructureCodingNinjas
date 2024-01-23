package LinkedListPackage;
import java.util.*;
public class InsertNode {


    public static Node<Integer> insertNode(Node<Integer> head, int pos, int data){
        //Your code goes here

        Node<Integer> nodeToBeInserted = new Node<>(data);


        if(pos == 0) {
            nodeToBeInserted.next = head;
            return nodeToBeInserted;
        }else{
            Node<Integer> prev = head;
            int count = 0;
            while(count < pos -1 && prev != null ) {
                count++;
                prev = prev.next;
            }
            if(prev != null){
                nodeToBeInserted.next = prev.next;
                prev.next = nodeToBeInserted;
            }
        }


        return head;

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node<Integer> head = LinkedListIInputDynamic.takeInput();
        System.out.print("Pos to insert = ");
        int pos = sc.nextInt();
        Node<Integer> insertedOutput = insertNode(head,pos, 999);
        LinkedListIInputDynamic.printLL(insertedOutput);

    }
}
