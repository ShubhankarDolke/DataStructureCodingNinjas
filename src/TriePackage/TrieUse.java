package TriePackage;

public class TrieUse {
    public static void main(String[] args) {

        Trie t = new Trie();
        t.add("AND");
        t.add("CAT");
        t.add("CAR");
        t.add("BAT");
        t.add("NOT");
        t.add("NOTE");

        System.out.println(t.search("NOT"));
        t.remove("NOT");
        System.out.println(t.search("NOT"));
        System.out.println(t.search("NOTE"));
    }
}
