package trees;
/*
 * @author love.bisaria on 14/09/18
 */


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import static org.junit.Assert.*;

/*
* A tree is "superbalanced" if the difference between the depths of any two leaf nodes ↴ is no greater than one.
*
*/
public class SuperBalancedBinaryTree {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static class BinaryTreeNodeHeightPair{

        public BinaryTreeNode node;
        public Integer height;

        public BinaryTreeNodeHeightPair(BinaryTreeNode node, Integer height){
            this.node = node;
            this.height = height;
        }
    }

    public static boolean isBalanced(BinaryTreeNode treeRoot) {

        // determine if the tree is superbalanced
        Stack<BinaryTreeNodeHeightPair> stack = new Stack();
        List<Integer> heights = new ArrayList();


        stack.push(new BinaryTreeNodeHeightPair(treeRoot, 0));

        while(!stack.isEmpty()){

            BinaryTreeNodeHeightPair treeNodePair = stack.pop();
            BinaryTreeNode node = treeNodePair.node;
            int d = treeNodePair.height;
            //leaf node
            if(node.left== null && node.right==null){
                if(!heights.contains(d)){
                    heights.add(d);

                    if(heights.size()>2 || (heights.size() ==2 && Math.abs(heights.get(0) - heights.get(1)) > 1)){
                        return false;
                    }
                }

            }else{ //not a leaf node just push it with its depth

                d +=1;
                if(node.left!= null){
                    stack.push(new BinaryTreeNodeHeightPair(node.left, d));
                }

                if(node.right!= null){
                    stack.push(new BinaryTreeNodeHeightPair(node.right, d));
                }
            }

        }


        return true;
    }


















    // tests

    @Test
    public void fullTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(8);
        final BinaryTreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final BinaryTreeNode root = new BinaryTreeNode(3);
        root.insertLeft(4).insertLeft(1);
        root.insertRight(2).insertRight(9);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByOneTest() {
        final BinaryTreeNode root = new BinaryTreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final BinaryTreeNode root = new BinaryTreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7).insertRight(8);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertLeft(5);
        final BinaryTreeNode b = root.insertRight(9);
        b.insertLeft(8).insertLeft(7);
        b.insertRight(5);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void onlyOneNodeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void treeIsLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertRight(2).insertRight(3).insertRight(4);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuperBalancedBinaryTree.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}

class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}
