package QueueUsingArrayPackage;

public class QueueUsingArrayUse {

    public static void main(String[] args) {

        QueueUsingArray q = new QueueUsingArray();

//        q.front();
//        q.enqueue(10);
        for(int i = 0; i < 5; i++) {
            q.enqueue(i);

        }
//        System.out.println(q.size());
//        for(int i = 0; i < q.size(); i++) {
//            System.out.print(q.print(i) + " ");
//        }
        for(int i = 0; i < 5; i++) {
            System.out.println(q.dequeue());

        }
        System.out.println(q.size() + "size" );

//        q.enqueue(22);
//
//        for(int i = 0; i < q.size(); i++) {
//            System.out.print(q.print(i) + " ");
//        }

    }
}
