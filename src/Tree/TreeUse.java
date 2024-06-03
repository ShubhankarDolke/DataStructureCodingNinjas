package Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

    public static TreeNode<Integer> takeInputLevelWise(){

        Scanner sc  = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingChildren = new LinkedList<>();

        System.out.print("Enter root Data: ");

        int rootData = sc.nextInt();
        if(rootData == -1) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<>(rootData);

        pendingChildren.add(root);

        while(!pendingChildren.isEmpty()) {
            TreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter number of children for node " + front.data );
            int numberOfChild = sc.nextInt();
            for(int i = 0; i < numberOfChild; i++) {
                System.out.println("Enter a data for " + (i + 1) + "th child " + front.data );
                int childData = sc.nextInt();
                TreeNode<Integer> child = new TreeNode<>(childData);
                front.children.add(child);
                pendingChildren.add(child);

            }
        }

        return root;


    }


    public static TreeNode<Integer> takeTreeInputRecursive(Scanner sc) {



        System.out.print("Enter Data: ");
        int data = sc.nextInt();

        TreeNode<Integer> root = new TreeNode<>(data);

        System.out.print("Enter Number of children : ");
        int childrenNumber = sc.nextInt();


        for(int i = 0; i < childrenNumber; i++) {
            System.out.println("Entering data for child " + (i + 1) + "th" + " of " + data);
            TreeNode<Integer> child = takeTreeInputRecursive(sc);
            root.children.add(child);

        }
        return root;

    }


    public static int numberOdNodes(TreeNode<Integer> root) {
        if(root == null) {
            return 0;

        }
        int count = 1;

        for(int i = 0; i < root.children.size(); i++) {
            int countChild = numberOdNodes(root.children.get(i));
            count += countChild;
        }
        return count;


    }

    public static void printTreeBasic(TreeNode<Integer> root) {
//        This is a special case not a base case
        if(root == null) {
            return;
        }


        System.out.print(root.data + " ");

        for(int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i); // getting node from children array
            printTreeBasic(child);
        }

    }


    public static void printTreeBetter(TreeNode<Integer> root) {

        if(root == null) {
            return;

        }

        System.out.print(root.data + ": ") ;

        for(int i = 0 ; i < root.children.size(); i++){
            System.out.print(root.children.get(i).data + " ");

        }
        System.out.println();

        for(int i = 0; i < root.children.size() ; i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTreeBetter(child);

        }

    }
    public static void main(String[] args) {


        /*
          4
        1   2   3
           5 6
         */

//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(1);
//        TreeNode<Integer> node2 = new TreeNode<>(2);
//        TreeNode<Integer> node3 = new TreeNode<>(3);
//        TreeNode<Integer> node4 = new TreeNode<>(5);
//        TreeNode<Integer> node5 = new TreeNode<>(6);
//
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//
//        node2.children.add(node4);
//        node2.children.add(node5);

//        printTreeBasic(root);
//        printTreeBetter(root);

//        int output = numberOdNodes(root);

//        System.out.println(output);

        Scanner sc = new Scanner(System.in);

//        TreeNode<Integer> root = takeTreeInputRecursive(sc);
        TreeNode<Integer> root = takeInputLevelWise();
        printTreeBetter(root);


    }
}
