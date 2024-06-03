package BinaryTreesPackage;

import java.util.*;

public class BinaryTreeUse {


    public static void main(String[] args) {

//        BinaryTreeNode <Integer> root = new BinaryTreeNode<>(1);
//
//        BinaryTreeNode <Integer> Rootleft = new BinaryTreeNode<>(2);
//
//        BinaryTreeNode <Integer> RootRight = new BinaryTreeNode<>(3);
//
//        root.left = Rootleft;
//        root.right = RootRight;
//
//        BinaryTreeNode <Integer> TwosRight = new BinaryTreeNode<>(4);
//
//        BinaryTreeNode <Integer> ThreesLeft = new BinaryTreeNode<>(5);
//
//        Rootleft.right = TwosRight;
//        RootRight.left = ThreesLeft;

//        printTree(root);
//        BinaryTreeNode <Integer> root = treeTakeInput();
//        BinaryTreeNode <Integer> root = treeTakeInputBetter(true, 0, true);
//          BinaryTreeNode <Integer> root = BinaryTreeLevelWise();
//        System.out.println(treeCountNode(root));
//        printTreeDetailed(root);
//        printTreeDetailedLevelWise(root);
//        System.out.println(largestDataInTree(root));

//        System.out.println(noOfLeafInTree(root));
//        int k = 2;
//        System.out.println("Depth of node " + k);
//        printDepthNodeAtK(root, k);

//        BinaryTreeNode<Integer> newRoot = removeLeaves(root);
//        printTreeDetailed(newRoot);

//        System.out.println("Is tree Balanced? " + isTrssBalancedBetter(root).isBalanced);

        int [] in = {4, 2, 5, 1, 3};
        int [] pre = {1, 2, 4, 5, 3};
        BinaryTreeNode<Integer> root = buildTreePreIn(pre, in);
        printTreeDetailed(root);

    }


    public static isBSTReturn isBSTBetter(BinaryTreeNode<Integer> root) {

        if(root == null) {
            isBSTReturn ans = new isBSTReturn(Integer.MIN_VALUE, Integer.MIN_VALUE, true);

            return ans;
        }

        isBSTReturn leftAns = isBSTBetter(root.left);
        isBSTReturn rightAns = isBSTBetter(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
        boolean isBST = true;

        if(leftAns.max >= root.data){
            isBST = false;
        }

        if(rightAns.min < root.data) {
            isBST = false;
        }

        if(!leftAns.isBST) {
            isBST = false;

        }

        if(!rightAns.isBST){
            isBST = false;
        }

        isBSTReturn ans = new isBSTReturn(min, max, isBST);

        return ans;

    }



    public static BinaryTreeNode<Integer> buildTreePreInHelper(int [] pre, int [] in, int siPre,int eiPre,int siIn,int eiIn) {

        if(siPre > eiPre) {
            return null;
        }

        int rootData = pre[siPre];

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;

        for(int i =  siIn; i <= eiIn; i++) {
            if(rootData == in[i]) {
                rootIndex = i;
                break;
            }

        }

        int siPreLeft = siPre + 1 ;
        int siInLeft= siIn;

        int eiInLeft = rootIndex - 1;

        int siInRight = rootIndex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;

        int leftSubTree = eiInLeft - siInLeft + 1;

        int eiPreLeft =  siPreLeft + leftSubTree - 1 ;
        int siPreRight = eiPreLeft + 1;


        BinaryTreeNode<Integer> left = buildTreePreInHelper(pre, in , siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        BinaryTreeNode<Integer> right = buildTreePreInHelper(pre, in , siPreRight, eiPreRight, siInRight, eiInRight);

        root.left = left;
        root.right = right;

        return root;

    }
    public static BinaryTreeNode<Integer> buildTreePreIn(int [] pre, int [] in) {

        return buildTreePreInHelper(pre, in, 0, pre.length- 1, 0, in.length- 1);

    }

    public static BalancedTreeReturn isTreeBalancedBetter(BinaryTreeNode<Integer> root) {

       if(root == null) {

           int height = 0;
           boolean isBal = true;
           BalancedTreeReturn ans = new BalancedTreeReturn();
           ans.height = height;
           ans.isBalanced = isBal;
           return ans;
       }

       BalancedTreeReturn leftBalanced = isTreeBalancedBetter(root.left);
       BalancedTreeReturn rightBalanced = isTreeBalancedBetter(root.right);
       boolean isBal = true;
       int height = 1 + Math.max(leftBalanced.height, rightBalanced.height);

       if(Math.abs(leftBalanced.height - rightBalanced.height ) > 1) {
           isBal = false;
       }

       if(!leftBalanced.isBalanced || !rightBalanced.isBalanced) {
           isBal = false;
       }

       BalancedTreeReturn ans = new BalancedTreeReturn();

       ans.height = height;
       ans.isBalanced = isBal;

       return ans;
    }
    public static int heightOfTree(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static boolean isTreeBalanced(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return true;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        if(Math.abs(leftHeight - rightHeight ) > 1) {
            return false;
        }

        boolean isLeftBalanced = isTreeBalanced(root.left);
        boolean isRightBalanced = isTreeBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

        return root;
    }


    public static void printDepthNodeAtK(BinaryTreeNode<Integer> root, int k) {

        if(root == null) {
            return;
        }

        if(k == 0) {
            System.out.print(root.data + " ");
        }

        printDepthNodeAtK(root.left, k -1);
        printDepthNodeAtK(root.right, k - 1);
    }

    public static int noOfLeafInTree(BinaryTreeNode<Integer> root) {

        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;

        }

        return noOfLeafInTree(root.left) + noOfLeafInTree(root.right);



    }

    public static int largestDataInTree(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return -1;
        }

        int largestLeft = largestDataInTree(root.left);
        int largestRight = largestDataInTree(root.right);

        return Math.max(root.data, Math.max(largestRight, largestLeft));
    }

    public static int smallestDataInTree(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return -1;
        }

        int smallestLeft = smallestDataInTree(root.left);
        int smallestRight = smallestDataInTree(root.right);

        return Math.min(root.data, Math.max(smallestLeft, smallestRight));
    }




    public static void printTreeDetailedLevelWise(BinaryTreeNode<Integer> root) {

        if(root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> childToPrint = new LinkedList<>();

        childToPrint.add(root);


        while(!childToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = childToPrint.poll();
            System.out.print(front.data+ ": ");
            if(front.left != null) {
                System.out.print(" L" + front.left.data );
            }
            if(front.right != null) {
                System.out.print(" R" + front.right.data);
            }
            System.out.println();

            if(front.left != null){
                childToPrint.add(front.left);
            }
            if(front.right != null) {
                childToPrint.add(front.right);

            }


        }
    }

    public static BinaryTreeNode<Integer> BinaryTreeLevelWise() {
        /*

1: take root input
2: take it into the Queue
3: while queue is not empty
4: a. take the first element out
   b. ask for its left
        if left is != -1
        attached this element to its left size and push to queue

    repeat for right same step b.

 return root

 */

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Root data ");
        int rootData = sc.nextInt();

        if(rootData == -1) {
            return null;
        }
        BinaryTreeNode <Integer> root = new BinaryTreeNode<>(rootData);

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);
        while(!pendingChildren.isEmpty()) {

            BinaryTreeNode<Integer> frontNode = pendingChildren.poll();
            System.out.println("Enter left data of " + frontNode.data);
            int left = sc.nextInt();
            if(left != -1) {
                BinaryTreeNode <Integer> leftChild = new BinaryTreeNode<>(left);
                frontNode.left = leftChild;
                pendingChildren.add(leftChild);

            }
            System.out.println("Enter right data of " + frontNode.data);
            int right = sc.nextInt();
            if(right != -1) {
                BinaryTreeNode <Integer> rightChild = new BinaryTreeNode<>(right);
                frontNode.right = rightChild;
                pendingChildren.add(rightChild);
            }

        }

        return root;
    }

    public static int treeCountNode(BinaryTreeNode <Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftNodeCount = treeCountNode(root.left);
        int rightNodeCount = treeCountNode(root.right);

        return 1 + leftNodeCount + rightNodeCount;

    }




    public static BinaryTreeNode<Integer> treeTakeInputBetter(boolean isRoot,int parentData, boolean isLeft ) {

        if(isRoot) {
            System.out.println("Enter Root Data");
        }else{
            if(isLeft) {
                System.out.println("Enter left Child of " + parentData);
            }else{
                System.out.println("Enter right Child of " + parentData);
            }

        }

        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();
        if(rootData == -1) {
            return null;
        }

        BinaryTreeNode <Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode <Integer> leftChild = treeTakeInputBetter(false, rootData, true);
        BinaryTreeNode <Integer> rightChild = treeTakeInputBetter(false, rootData, false);
        root.left = leftChild;
        root.right = rightChild;

        return root;



    }

    public static BinaryTreeNode<Integer> treeTakeInput() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode <Integer> root = new BinaryTreeNode<>(data);

        BinaryTreeNode <Integer> leftChild = treeTakeInput();
        BinaryTreeNode <Integer> rightChild = treeTakeInput();

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {

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

    public static void printTree(BinaryTreeNode<Integer> root) {

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
