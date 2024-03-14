package StackPackage;

public class StackUsingLinkedListUse {
    public static void main(String[] args) {

        StackUsingLinkedList stackLL = new StackUsingLinkedList<>();

        stackLL.push(10);
        stackLL.push(20);
        System.out.println(stackLL.size());
        System.out.println(stackLL.top());
        System.out.println(stackLL.pop());
        System.out.println(stackLL.size());
        System.out.println(stackLL.top());

    }
}
