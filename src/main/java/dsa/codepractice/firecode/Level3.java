package dsa.codepractice.firecode;

import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dsa.datastructures.linkedList.Node;
import dsa.datastructures.trees.TreeNode;

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

        //fix this code
        // ArrayList<Integer> order = new ArrayList<>();
        // LinkedList<TreeNode> s = new LinkedList<>();
        // TreeNode temp = root;
        // s.push(temp);

        // while(!s.isEmpty()){
        //     if(temp.left!=null&&!order.contains(temp.left.data)){
        //         s.add(temp);
        //         temp=temp.left;
        //     }else{
        //         temp = s.pop();
        //         order.add(temp.data);
        //         if(temp.right!=null){
        //             s.push(temp.right);
        //             temp=temp.right;
        //         }
        //     }
        // }
        // return order;
        /* 
        There version
        <pre>
        @code{*/
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
    /*}
        </pre>
        */
    }

    /**
     * max sum of left, right, and root of tree by comparing greatest values of paths.
     * 
     * <p>
     * O(n) Time and O(log n) Space
     * 
     * @param root
     * @return
     */
    public int maxSumPath(TreeNode root){
        int[] maxValueHolder = new int[1];
        //you use an array object because primitive values sent into a method
        //don't get modified
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
     * find the kth largest element in a BST
     * 
     * <p> O(n) Time and O(log n) Space
     * 
     * @param root
     * @param k
     * @return
     */
    public TreeNode findKthLargest(TreeNode root, int k){
        // if(root==null) return root;
        // int rightSize=0;
        // if(root.right!=null){
        //     //rightSize=size(root.right); need to figure out this mysterious size method
        // }
        // if(rightSize+1==k){
        //     return root;
        // }else if(k<=rightSize){
        //     return findKthLargest(root.right, k);
        // }else{
        //     return findKthLargest(root.left, k-rightSize-1);
        // }

        TreeNode temp = root;
        LinkedList<TreeNode> s = new LinkedList<>();

        while(!s.isEmpty()||temp!=null){
            if(temp!=null){
                s.push(temp);
                temp = temp.right;
            }else{
                temp = s.pop();
                if(k--==1){
                    return temp;
                }
                temp = temp.left;
            }
        }
        return temp;
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

    /**
     * find all possible paths from the top left corner to the bottom right in a
     * multi-dimensional array only going in two directions: right and down. This
     * uses a DFS algorithm on a graph problem.
     * 
     * <p>
     * O(b^d) Time (b = branching in this case = 2 because only going down and right
     * and d = m+n where m represents the length of the row and n represents the length
     * of the column.)
     * 
     * <p>
     * O(bxd) Space using same answers for b and d above. 
     * @param board
     * @return
     */
    public List<String> printPaths(char[][] board){
        ArrayList<String> paths = new ArrayList<>();
        StringBuilder pPaths = new StringBuilder();
        search(board, paths, pPaths, 0,0);
        return paths;
    }

    /**
     * printPaths helper method that uses DFS algorithm to find all possible paths
     * 
     * @param board
     * @param paths
     * @param pPaths
     * @param row
     * @param col
     */
    public void search(char[][] board, List<String> paths, StringBuilder pPaths, int row, int col){
        if(board==null||row>board.length-1||col>board[0].length){
            return;
        }
        pPaths.append(board[row][col]);
        if(row==board.length-1&&col==board[0].length-1){
            paths.add(pPaths.toString());
            pPaths.deleteCharAt(pPaths.length()-1);
            return;
        }
        search(board, paths, pPaths, row+1, col);
        search(board, paths, pPaths, row, col+1);
        pPaths.deleteCharAt(pPaths.length()-1);
    }

    /**
     * insert a node into a BST 
     * 
     * <p>
     * O(log n) Time and O(log n) Space for recursive and O(1) for iterative
     * 
     * @param root
     * @param data
     * @return
     */
    public TreeNode insert(TreeNode root, int data){
        if(root==null) return new TreeNode(data);

        if(data<root.data){
            if(root.right!=null){
                insert(root.right, data);
            }else{
                root.right = new TreeNode(data);
            }
        }else{
            if(root.left!=null){
                insert(root.right,data);
            }else{
                root.right = new TreeNode(data);
            }
        }
        //Someone else's version
        //if(data<root.data) root.left=insert(root.left, data); 
        //else root.right=insert(root.right, data);

        //iterative solution
        /* 
        TreeNode curr = root;
        boolean inserted = false;
        while(!inserted){
            if(data<curr.data){
                if(curr.right!=null){
                    curr = curr.right;
                }else{
                    curr.right = new TreeNode(data);
                    inserted = true;
                }
            }else{
                if(curr.left!=null){
                    curr = curr.right;
                }else{
                    curr.right = new TreeNode(data);
                    inserted = true;
                }
            }
        }
        */

        return root;
    }

    /**
     * find the smallest value in a BST.
     * 
     * <p>
     * O(log n) Time and Space
     * 
     * @param root
     * @return
     */
    public TreeNode findMin(TreeNode root){
        if(root==null) return root;
        return root!=null ? findMin(root.left) : root;

        /*
         * Iterative solution
         * 
         * TreeNode curr = root;
         * While(cur.left!=null){
         *  curr= curr.left
         * }
         * return curr;
         */
    }

    /**
     * find if a number is happy by these rules: if number ==1
     * after repeatedly summing the number's digits, if not then
     * it's not a happy num
     * 
     * <p>
     * Example: 19 = 1^2+ 9^2 = 82
     * <p>8^2 + 2^2 = 68
     * <p> 6^+8^2 = 100
     * <p> 1^2 + 0 + 0 = 1
     * <p> return true
     * 
     * <p>
     * O(n^2) Time and O(n) Space
     * 
     * @param n
     * @return
     */
    public static boolean isHappyNumber(int n) {
        //Fix this string solution
        // if(n<10&&n==1) return true;
        // int arrSize = 2;
        
        // while(arrSize>1){
        //     String happyString = Integer.toString(n);
        //     arrSize = happyString.length();
        //     for(int i=0;i<arrSize-1; i++){
        //         int temp = Integer.parseInt(happyString.substring(i,i+1));
        //         n+= temp*temp;
        //     }
        //     if(n==1) return true;
        // }
        // return false;
        if(n<10&&n==1) return true;
        int[] arr = happyHelper(n);
        int sum = n;
        while(sum>9){
            sum =0;
            for(int i=0;i<arr.length;i++){
                sum += arr[i]*arr[i];
            }
            if(sum==1){
                return true;
            }
            arr = happyHelper(sum);
        }
        return false;
    }
    public static int[] happyHelper(int n){
        String s = Integer.toString(n); //String.valueOf(n)
        int length = s.length();
        int[] arr = new int[length];
        int i=0;
        while(n>0){
            int rem = n%10;
            arr[i++] = rem;
            n/=10;
        }
        return arr;
    }

    /**
     * find all valid cominbations of parentheses
     * 
     * <p>This method does not work because it includes all combinations,
     * not all valid combinations.
     * 
     * @param pairs
     * @return
     */
    public static List<String> combineParenthesis(int pairs){
        ArrayList<String> paired = new ArrayList<>();
        if(pairs>0){
            combineParenthesisHelper(paired, "", pairs, pairs);
        }
        return paired;
    }

    public static void combineParenthesisHelper(List<String> paired, String temp, int leftPair, int rightPair){
        if(leftPair==0&&rightPair==0){
            paired.add(temp);
        }else{
            if(leftPair>0){
                combineParenthesisHelper(paired, temp+"(", leftPair-1, rightPair);
            }
            if(rightPair>leftPair){
                combineParenthesisHelper(paired, temp+")", leftPair, rightPair-1);
            }
        }
        return;
    }

    /**
     * delete node at specified position in doubly linked list
     * 
     * <p>
     * O(n) Time O(1) Space
     * @param head
     * @param pos
     * @return
     */
    public Node deleteAtPos(Node head, int pos){
        if(head==null||(head.next==null&&pos==1)) return null;
        if(pos<1){
            return head;
        }
        Node prev = head;
        Node curr = head;

        if(pos==1){
            head = head.next;
            head.prev=null;
            curr.next=null;
            curr=null;
            return head;
        }

        int count=1;
        while(curr!=null){
            if(pos==count){
                prev.next=curr.next;
                if(curr.next!=null){
                    curr.next.prev = prev;
                    curr.next=null;
                }
                curr.prev=null;
                curr=null;
                return head;
            }
            prev=curr;
            curr=curr.next;
            count++;
        }
        return head;
    }

    /**
     * add all the elements in the binary tree
     * 
     * <p>
     * O(n) Time for recursive and Iterative, O(log n) for recursive and O(n) for iterative
     * @param root
     * @return
     */
    public int sumBinaryTree(TreeNode root){
        //recursive solution
        //if(root==null) return 0;
        //return root.data+sumBinaryTree(root.left)+sumBinaryTree(root.right);

        //Iterative solution
        if(root==null) return 0;
        int sum =0;
        TreeNode temp = root;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);
        
        while(!q.isEmpty()){
            temp = q.pop();
            sum+=temp.data;
            if(temp.left!=null){
                q.push(temp.left);
            }
            if(temp.right!=null){
                q.push(temp.right);
            }
        }
        return sum;
    }

    /**
     * insert node at the head of a doubly linked list
     * 
     * <p>
     * O(1) Time
     * 
     * @param head
     * @param data
     * @return
     */
    public Node insertAtHead(Node head,int data){
        if(head==null) return new Node(data);
        Node newHead = head;
        newHead.next = head;
        newHead.prev = null;
        head.prev = newHead;
        head = newHead;
        return head;
    }

    /**
     * return the maxProfits. This is a really confusing question
     * 
     * <p> O(n) Time and O(1) Space
     * 
     * @param close
     * @return
     */
    public int maxProfits(int[] close){
        int profits = 0;

        for(int i=0;i<close.length-1;i++){
            if(close[i+1]>close[i]){
                profits += close[i+1]-close[i];
            }
        }
        return profits;
    }

    /**
     * count the number of possible paths from the top left to the bottom
     * right only going down or right. 
     * 
     * <p>This is a Dynamic Progaming problem and the jist of it is adding up
     * all possible moves from an adjacent row either going down or right.
     * 
     * <p>O(mxn) Time and Space
     * 
     * @param m
     * @param n
     * @return
     */
    public int countPaths(int m, int n){
        if(m==1&&n==1) return 1;

        int[][] memo = new int[m][n];
        for(int i = 0;i<m;i++){
            memo[i][0]++;
        }

        for(int i = 0;i<n;i++){
            memo[0][i]++;
        }
        //Fill the memo matrix 1st row and col with 1's because there's
        //only one way to go from the previous pos on a row or col to the
        //next position going only down or right

        for(int i = 1;i<m;i++){
            for(int j=1;j<n;j++){
                memo[i][j]=memo[i-1][j]+memo[i][j-1];
            }
        }
        //Adds up all the combinations and returns the last cell which is the
        //answer
        return memo[m-1][n-1];
    }
}