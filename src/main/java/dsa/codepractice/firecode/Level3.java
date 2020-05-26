package dsa.codepractice.firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level3 {

    public Node findNthNodeFromEnd(Node head){
        int count=1;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        count-=n;

        int position = 0;
        temp=head;
        while(temp!=null){
            if(count==position){
                return temp;
            }
            temp=temp.next;
        }
        return temp;
    }

    /**
     * inorder traversal of a tree iteratively.
     * 
     * <p>
     * O(n) Time and O(log n) Space < - I think is O(n) space
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        if(root==null) return new ArrayList<>();

        ArrayList<Integer> order = new ArrayList<>();
        LinkedList<TreeNode> s = new LinkedList<>();
        TreeNode temp = root;
        s.push(temp);

        while(!s.isEmpty()){
            if(temp.left!=null&&!order.contains(temp.left.data)){
                s.add(temp);
                temp=temp.left;
            }else{
                temp = s.pop();
                order.add(temp.data);
                if(temp.right!=null){
                    s.push(temp.right);
                    temp=temp.right;
                }
            }
        }
        return order;
        /* 
        There version
        <pre>
        @code{
        ArrayList<Integer> order = new ArrayList<>();
        LinkedList<TreeNode> s = new LinkedList<>();
        //s.push(root);
        while(true){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            if(s.isEmpty())break;
            root = s.pop();
            order.add(root.data);
            root=root.right;
        } 
        return order;
    }
        </pre>
        */
    }

    /**
     * max sum of left, right, and root of tree by comparing greatest values of paths.
     * 
     * <p>
     * O(n) Time and O(log n) Space?
     * 
     * @param root
     * @return
     */
    public int maxSumPath(TreeNode root){
        int[] maxValueHolder = new int[1];
        maxSumPathHelper(root, maxValueHolder);
        return maxValueHolder[0];
    }

    /**
     * maxSumHelper method 
     * 
     * @param root
     * @param maxValueHolder
     * @return
     */
    public int maxSumPathHelper(TreeNode root, int[] maxValueHolder){
        if(root==null) return 0;
        int leftSum = maxSumPathHelper(root.left, maxValueHolder);
        int rightSum = maxSumPathHelper(root.right, maxValueHolder);
        //gets the greatestPathValue for both sides of tree depending on where you are in the recurison.
        int greatestPathValue = Math.max(root.data + leftSum, root.data + rightSum);
        //stores the maxSum of the greatValue from the right, left, and the root value.
        maxValueHolder[0] = Math.max(maxValueHolder[0],leftSum + root.data + rightSum);
        return greatestPathValue;
    }


	class Node{
        int data;
        Node next;
    }

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
}