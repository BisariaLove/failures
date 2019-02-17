package trees;
/*
 * @author love.bisaria on 22/09/18
 */

import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {

    Node root;

    private BinarySearchTree(Node head){
        this.root = head;
    }

    private static Node from(List<Integer> sortedList, int start, int end){

        if(start > end) return null;

        int mid = (start+end)/2;

        Node root = new Node(sortedList.get(mid));

        root.left = from(sortedList, start, mid-1);
        root.right = from(sortedList, mid+1, end);

        return root;

    }

    public static BinarySearchTree from(List<Integer> sortedList){
        Node root =  from(sortedList, 0, sortedList.size()-1);
        return new BinarySearchTree(root);

    }

    public static void inOrderTraversal(Node node){
        if(node.left != null){
            inOrderTraversal(node.left);
        }

        System.out.println(node.val);

        if(node.right != null){
            inOrderTraversal(node.right);
        }

    }

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(9, 12, 14, 19, 23, 17, 50, 54, 67,72, 76);
        BinarySearchTree node = BinarySearchTree.from(numbers);

        inOrderTraversal(node.root);
    }
}

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
