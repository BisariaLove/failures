package trees;
/*
 * @author love.bisaria on 11/10/18
 */

public class FindSecondLargest {


}

class BTreeNode{

    int val;
    BTreeNode left;
    BTreeNode right;

    public BTreeNode(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }

    public void insertLeft(int data){
        this.left = new BTreeNode(data);
    }

    public void insertRight(int data){
        this.right = new BTreeNode(data);
    }
}
