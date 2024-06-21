package PriorityQueuePackage;

public class Priority_Queue_Test {
    public static void main(String[] args) throws PriorityQueueEmptyException {

        Priority_Queue<String> pq = new Priority_Queue<>();

        pq.insert("abc", 15);
        pq.insert("def", 13);
        pq.insert("fsas", 90);
        pq.insert("fassasaa", 150);
        pq.insert("SVxcbbF", 120);

        while(!pq.isEmpty()) {
            System.out.println(pq.getMin());
            pq.removeMin();
        }


    }
}
