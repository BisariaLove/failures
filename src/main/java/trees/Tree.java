package trees;

import java.util.*;



class TreeNode{

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

}


public class Tree{


    TreeNode head;

    Map<Integer, TreeNode> valToNodeMap = new HashMap();

    public void insertNode(int val){

        if(head == null){
            head  = new TreeNode(val);
            return;
        }
        insertNode(val, head);
    }

    private void insertNode(int val, TreeNode node){

        if(val< node.data){

            if(node.left == null){
                TreeNode n = new TreeNode(val);
                valToNodeMap.put(val, n);
                node.left = n;
            }else{
                insertNode(val, node.left);
            }

        }else{
            if(node.right == null){
                TreeNode n = new TreeNode(val);
                valToNodeMap.put(val, n);
                node.right = n;
            }else{
                insertNode(val,node.right);
            }
        }
    }


    public boolean contains(int val){


        if(head == null){
            return false;
        }
        return contains(val, head);
    }

    private boolean contains(int val, TreeNode node){
        if(val == node.data){
            return true;
        }

        if(val< node.data){
            if(node.left == null){
                return false;
            }
            return contains(val, node.left);
        }else{
            if(node.right == null){
                return false;
            }
            return contains(val, node.right);
        }
    }

    public void inOrderTraversal(){
        inOrderTraversal(head);
    }

    public void inOrderTraversalIterative(){

        Stack<TreeNode> stack = new Stack();
        stack.push(head);
        TreeNode currentNode = head;

        while(!stack.isEmpty()){
            if(currentNode.left != null){
                stack.push(currentNode.left);
                currentNode = currentNode.left;
                continue;
            }

            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");

            if(currentNode.right != null){
                stack.push(currentNode.right);
                currentNode = currentNode.right;
            }

        }
    }

    private void inOrderTraversal(TreeNode node){


        if(node.left != null){
            inOrderTraversal(node.left);
        }

        System.out.println(node.data);

        if(node.right != null){
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(){
        preOrderTraversal(head);
    }

    private  void preOrderTraversal(TreeNode node){
        System.out.print (node.data + " ");

        if(node.left != null){
            preOrderTraversal(node.left);
        }

        if(node.right != null){
            preOrderTraversal(node.right);
        }
    }

    public void preOrderTraversalIterative(){
        Stack<TreeNode> stack = new Stack();

        stack.push(head);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            System.out.print(node.data + " ");

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }

    }


    public Integer leastCommonAncestor(Integer aNode, Integer bNode){

        TreeNode a = valToNodeMap.get(aNode);
        TreeNode b = valToNodeMap.get(bNode);

        return lca(this.head, a, b).data;
    }

    public TreeNode lca(TreeNode root, TreeNode a, TreeNode b){

        if(root == null) return null;

        TreeNode e = lca(root.left, a, b);
        TreeNode d = lca(root.right, a, b);

        if(root == a || root == b){
           return root;
        }

        if(e !=null && d != null){
            return root;
        } else if(e!= null){
            return e;
        } else {
            return d;
        }


    }


    public static void main(String[] args){

        Tree tree = new Tree();

        tree.insertNode(10);
        tree.insertNode(4);
        tree.insertNode(11);
        tree.insertNode(12);

        System.out.println(tree.contains(11));
        tree.inOrderTraversal();
        tree.inOrderTraversalIterative();
        System.out.println();
        System.out.println("##########PreOrder Traversals###########");
        tree.preOrderTraversal();
        System.out.println();
        tree.preOrderTraversalIterative();

        Integer res = tree.leastCommonAncestor(4, 12);

        System.out.println("Result is: " + res);
    }

}

