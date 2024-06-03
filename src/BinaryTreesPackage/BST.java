package BinaryTreesPackage;

public class BST {

    private BinaryTreeNode<Integer> root;
    private int size;



    private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int data) {

        if(node == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);

            return newNode;
        }

        if(data >= node.data) {
            node.right = insert(node.right, data);

        }else{
            node.left = insert(node.left, data);
        }

        return node;
    }
    public void insert(int data) {
        root = insert(root, data);
        size++;
    }

    private boolean isPresentHelper(BinaryTreeNode<Integer> root, int data) {

        if(root == null) {
            return false;

        }
        if(root.data == data) {
            return true;
        }
        if(root.data > data) {
            return isPresentHelper(root.left, data);
        }else{
            return isPresentHelper(root.right, data);
        }

    }

    public boolean isPresent(int data) {
        return isPresentHelper(root, data);
    }

    public int size() {
        return size;

    }


    private void printTreeHelper(BinaryTreeNode<Integer> root) {

        if(root == null){
            return;
        }

        System.out.print(root.data + ":");

        if(root.left != null) {
            System.out.print("L" + root.left.data+ ",");
        }
        if(root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printTreeHelper(root.left);
        printTreeHelper(root.right);

    }

    public void printTree(){

        printTreeHelper(root);
    }

    private BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int data) {
        if(root == null) {
            return new BSTDeleteReturn(null, false);
        }
        if(root.data < data) {
            BSTDeleteReturn outputRight =  deleteDataHelper(root.right,data);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;

        }

        if(root.data > data) {
            BSTDeleteReturn outputLeft =  deleteDataHelper(root.left, data);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }

//        0 child;
        if(root.left == null && root.right == null) {
            return new BSTDeleteReturn(null, true);
        }
//        left child;

        if(root.left != null && root.right == null) {
            return new BSTDeleteReturn(root.left, true);

        }

//        right child;

        if(root.left == null && root.right != null) {
            return new BSTDeleteReturn(root.right, true);

        }
//        both child;

       int minimumRight = smallestDataInTree(root.right);
        root.data = minimumRight;
        BSTDeleteReturn outputRight = deleteDataHelper(root.right,minimumRight);

        root.right = outputRight.root;
        return new BSTDeleteReturn(root, true);





    }

    private static int smallestDataInTree(BinaryTreeNode<Integer> root) {

        if(root == null) {
            return Integer.MAX_VALUE;
        }

        while(root.left != null) {
            root = root.left;

        }
        return root.data;

    }


    public boolean deleteData(int data) {

        BSTDeleteReturn output = deleteDataHelper(root, data);
        root = output.root;

        if(output.deleted) {
            size--;
        }
        return output.deleted;

    }




}

