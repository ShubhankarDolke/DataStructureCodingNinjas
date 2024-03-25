package QueueUsingLinkedListPackage;

public class QueueUsingLinkedListUse {

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();

        q.enqueue(12);
        q.enqueue(13);

        System.out.println(q.size());
        System.out.println(q.front());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());


    }
}
