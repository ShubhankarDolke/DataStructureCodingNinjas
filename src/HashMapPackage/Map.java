package HashMapPackage;

import java.util.ArrayList;

public class Map<K, V> {

    ArrayList<MapNode<K, V>> buckets;

    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 5;

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    public double loadFactor() {
        return (1.0 * count) / numBuckets;
    }


//    private int getBucketIndex(K key) {
//        int hc = key.hashCode();
//        int bucketIndex = Math.abs(hc) % numBuckets;
//        return bucketIndex;
//    }

//    private int getBucketIndex(K key) {
//        int hc = key.hashCode();
//        int bucketIndex = (hc & 0x7fffffff) % numBuckets; // Ensure non-negative index
//        return bucketIndex;
//    }
    private int getBucketIndex(K key) {

        int hc = key.hashCode();
        int keyLength = key.toString().length(); // Assuming key is a String
        int bucketIndex = (hc ^ keyLength) % numBuckets;
        return bucketIndex;
    }


    public void insert(K key, V value) {

        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);

// checks for the key if any replaces value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;

        }
//creats new node and attaches itself to head node in LL
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++; // increasing size of map count

        double loadFactor = (1.0 * count) / numBuckets;
        if (loadFactor >= 0.7) {
            reHash();

        }
    }

    private void reHash() {
        ArrayList<MapNode<K, V>> temp = buckets;

        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets * 2; i++) {
            buckets.add(null);
        }
        count = 0;
        numBuckets = numBuckets * 2;


        for (int i = 0; i < temp.size(); i++) {

            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);

        MapNode<K, V> head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public int size() {
        return count;
    }


    public V removeKey(K key) {

        int bucketIndex = getBucketIndex(key);

        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;

        while (head != null) {

            if (head.key.equals(key)) {

                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;

        }
        return null;


    }


}
