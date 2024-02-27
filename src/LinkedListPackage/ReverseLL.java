package LinkedListPackage;


import java.util.Scanner;

class DoubleNode {
    Node<Integer> head;
    Node<Integer> tail;

    DoubleNode() {

    }

    DoubleNode(Node<Integer> head, Node<Integer> tail) {
        this.head = head;
        this.tail = tail;

    }

}

public class ReverseLL {
    public static Node<Integer> reverseR(Node<Integer> head) {

        if(head == null || head.next == null) {
            return head;

        }

        Node<Integer> smallHead = reverseR(head.next);
        Node<Integer> tail = smallHead;
        while(tail.next != null) {
            tail = tail.next;

        }
        tail.next = head;
        head.next = null;

        return smallHead;
    }







    public static DoubleNode reverseLLBetter(Node<Integer> head) {
        DoubleNode ans;

        if(head == null || head.next == null) {
            ans = new DoubleNode(head, head);
            return ans;
        }

        DoubleNode smallAns = reverseLLBetter(head.next);

        smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode(smallAns.head,head );
        return ans;



    }

    public static void printR(Node<Integer> head){
        if(head==null){
            return ;
        }
        printR(head.next);
        System.out.print(head.data+" ");
    }

    public static Node<Integer> takeInput() {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);

            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }

            data = scanner.nextInt();
        }

        return head;
    }



    public static void main(String[] args) {

        Node<Integer> head = takeInput();
         DoubleNode ans = reverseLLBetter(head);
         printR(ans.head);


    }


}



