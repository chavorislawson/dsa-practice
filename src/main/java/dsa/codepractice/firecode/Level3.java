package dsa.codepractice.firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level3 {

    public Node findNthNodeFromEnd(Node head, int n){
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

    /**
     * rotates an integer array by a number of digits to the left.
     * 
     * <p>
     * O(n) Time, O(1) Space
     * 
     * @param arr
     * @param k
     * @return
     */
    public int[] rotateLeft(int[] arr, int k){
        if(arr==null) return new int[]{};
        int s = k % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, arr.length-s-1);
        reverse(arr, arr.length-s, arr.length-1);
        return arr;
        /* brute force solution
        if(arr==null||arr.length<2||k==0||k==arr.length){
            return arr;
        }
        int temp=0;

        for(int i=0;i<k;i++){
            for(int j=0;j<arr.length-1;i++){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        */
    }

    /**
     * helper method for rotateLeft by first reversing the array, the switching the
     * new front, and then swithching the new back.
     * 
     * @param arr
     * @param left
     * @param right
     */
    public void reverse(int[] arr, int left, int right){
        if(arr==null||arr.length==1) return;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * find the kth largest element in a BST (is not working right now)
     * 
     * @param root
     * @param k
     * @return
     */
    public TreeNode findKthLargest(TreeNode root, int k){
        if(root==null) return root;
        int rightSize=0;
        if(root.right!=null){
            //rightSize=size(root.right); need to figure out this mysterious size method
        }
        if(rightSize+1==k){
            return root;
        }else if(k<=rightSize){
            return findKthLargest(root.right, k);
        }else{
            return findKthLargest(root.left, k-rightSize-1);
        }
    }

    /**
     * find the number of half nodes (nodes who have one child) in a Binary Tree
     * 
     * <p>
     * O(n) Space (iterative soln)
     * 
     * @param root
     * @return
     */
    public int findNumberOfHalfNodes(TreeNode root){
        int total = 0;
        if(root==null) return total;
        return (root.right!=null&&root.left==null)||(root.right==null&&root.left!=null) ? total+1+findNumberOfHalfNodes(root.left)+findNumberOfHalfNodes(root.right): total+findNumberOfHalfNodes(root.right)+findNumberOfHalfNodes(root.left);
        /*
        My OG solution
        if(root.right!=null&&root.left==null){
            total+=1+findNumberOfHalfNodes(root.right);
        }else if (root.right==null&&root.left!=null){
            total+=1+findNumberOfHalfNodes(root.left);
        }else{
            total+=findNumberOfHalfNodes(root.right)+findNumberOfHalfNodes(root.left);
        }
        return total;

        //super clean recursion
        if(root.right==null ^ root.left==null) //xor
            total=1;
        return total+ findNumberOfHalfNodes(root.right)+findNumberOfHalfNodes(root.left);

        //there iterative solution
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode curr = null
        while(!q.isEmpty()){
            curr = q.remove();
            if((curr.right!=null&&curr.left==null)||(curr.right==null&&curr.left!=null)){
                total++;
            }
            if(curr.left!=null){
                q.add(curr.right);
            }if(curr.right!=null){
                q.add(curr.left);
            }
        }
        return total;

        */
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