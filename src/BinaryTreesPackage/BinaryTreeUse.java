package BinaryTreesPackage;

public class BinaryTreeUse {


    public static void main(String[] args) {

        BinaryTreeNode <Integer> root = new BinaryTreeNode<>(1);

        BinaryTreeNode <Integer> Rootleft = new BinaryTreeNode<>(2);

        BinaryTreeNode <Integer> RootRight = new BinaryTreeNode<>(3);

        root.left = Rootleft;
        root.right = RootRight;

        BinaryTreeNode <Integer> TwosRight = new BinaryTreeNode<>(4);

        BinaryTreeNode <Integer> ThreesLeft = new BinaryTreeNode<>(5);

        Rootleft.right = TwosRight;
        RootRight.left = ThreesLeft;

//        printTree(root);
        printTreeDetailed(root);



    }

    private static void printTreeDetailed(BinaryTreeNode<Integer> root) {

        if(root == null) {
            return;

        }
        System.out.print(root.data + ": ");
        if(root.left != null) {
            System.out.print("L"+root.left.data + ", ");
        }

        if(root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);

    }

    private static void printTree(BinaryTreeNode<Integer> root) {

        if(root == null) {
            return;
        }

        System.out.println(root.data);

        printTree(root.left);
        printTree(root.right);

//        if(root.left != null) {
//            printTree(root.left);
//        }
//
//        if(root.right != null) {
//            printTree(root.right);
//        }


    }


}
