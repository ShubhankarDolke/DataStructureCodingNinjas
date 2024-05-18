package BinaryTreesPackage;

public class BST {

    private BinaryTreeNode<Integer> root;
    private int size;



    private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int data) {

        if(node == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);

            return newNode;
        }

        if(data >= root.data) {
            node.right = insert(node.right, data);

        }else{
            node.left = insert(node.left, data);
        }

        return node;
    }
    public void insert(int data) {
        root = insert(root, data);
    }

    private boolean isPresentHelper(BinaryTreeNode<Integer> root, int data) {

        if(root == null) {
            return false;

        }
        if(root.data == data) {
            return true;
        }
        if(root.data > data) {
            isPresentHelper(root.left, data);
        }else{
            isPresentHelper(root.right, data);
        }
        return false;
    }

    public boolean isPresent(int data) {
        return isPresentHelper(root, data);
    }



    public boolean deleteData(int data) {
        return false;

    }

    public int size() {
        return size;

    }


    private void printTreeHelper(BinaryTreeNode<Integer> root) {

        if(root == null){
            return;
        }

        System.out.print(root.data + " :");

        if(root.left != null) {
            System.out.print("L" + root.left.data+ ",");
        }
        if(root.right != null) {
            System.out.print("R" + root.right.data+ ",");
        }
        System.out.println();

        printTreeHelper(root.right);
        printTreeHelper(root.right);

    }

    public void printTree(){

        printTreeHelper(root);
    }




}

