package dsa.codepractice.firecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import dsa.datastructures.linkedList.Node;

public class Level2 {

    /**
     * returns fibonacci sequence up to n
     * 
     * @param n
     * @return
     */
    public int fib(int n) {
        return n < 2 ? n : fib(n - 1) + fib(n - 2);
    }

    /**
     * are they the same length? are they the same case? do they contain letters?
     * are they empty? is each letter in one in two?
     * 
     * time complexity: O(n) linear space complexity: O(1) Constant
     * 
     * @param one
     * @param two
     * @return
     */
    public boolean permutation(String one, String two) {

        if (one.length() != two.length()) {
            return false;
        }
        int[] letters = new int[256];// because there are 256 ASCII characters. Not common sense, but it's common
                                     // knowledge.
        char[] c = one.toCharArray();

        for (char a : c) {
            letters[a]++;
        }
        for (int i = 0; i < two.length(); i++) {
            int s = (int) two.charAt(i);

            if (--letters[s] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find the Max Element in a Binary Tree Recursively
     * 
     * @param root
     * @return
     */
    public int findMax(TreeNode root) {
        int rtd = Integer.MIN_VALUE, ld = Integer.MIN_VALUE, rd = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        ld = 0;
        rtd = 0;
        rd = 0;
        if (root != null) {
            rtd = root.data;
            ld = findMax(root.left);
            rd = findMax(root.right);
            if (ld > rd) {
                max = ld;
            } else {
                max = rd;
            }
            if (rtd > max) {
                max = rtd;
            }
        }
        return max;
    }

    /**
     * returns the size of Binary Tree
     * 
     * 
     * <p>
     * O(n) Time, O(log n) space
     * 
     * @param root
     * @return
     */
    public int size(TreeNode root) {
        return root == null ? 0 : size(root.right) + 1 + size(root.left);
    }

    /**
     * determines if tree is BinarySearch Tree with helper function
     * 
     * <p>
     * O(n) Time, and O(1) Space
     * 
     * @param root
     * @return
     */
    public boolean validateBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * helper function to determine if tree is Binary Search Tree
     * 
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean validateBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }

    /**
     * <p>
     * Checks if two strings are isomorphic of each other. This needs further
     * explanation. Ex. dss and cll are isomorphic because they share the same
     * structure
     * 
     * <p>
     * O(n) space and time;
     * 
     * @param one
     * @param two
     * @return
     */
    public boolean isIsomorphic(String one, String two) {
        if (one.length() < two.length() || two.isEmpty()) {
            return true;
        }
        HashMap<Character, Integer> o = new HashMap<>();
        HashMap<Character, Integer> t = new HashMap<>();

        for (int i = 0; i < two.length(); i++) {
            char c1 = one.charAt(i);
            int val1 = o.get(c1) == null ? 1 : o.get(c1) + 1;
            o.put(c1, val1);

            char c2 = two.charAt(i);
            int val2 = t.get(c2) == null ? 1 : t.get(c2) + 1;
            t.put(c2, val2);

            if (!o.get(c1).equals(t.get(c2))) {
                return false;
            }

        }
        return true;
    }

    /**
     * removes node at specified index +
     * 
     * <p>
     * O(n) Time and O(1) Space
     * 
     * @param index
     * @return
     */
    public Node remove(Node head, int index) {
        if (index == 1) {
            return head == null ? head : head.getNext();
        }
        Node curr = head;
        Node prev = head;

        while (curr != null) {
            --index;
            if (index == 0) {
                prev.setNext(curr.getNext());
                curr.setNext(null);
            }
            prev = curr;
            curr = curr.getNext();
        }
        return head;
    }

    /**
     * recursive pre-order traversal of Binary Tree
     * 
     * <p>
     * This shit was easy asf, and I did not expect it to be. Got it basically on my
     * first attempt. just missed some closing marks
     * 
     * <p>
     * O(n) Time and O(log n) Space - recursion overhead in average case
     * 
     * @param list
     * @param root
     */
    public void preorder(ArrayList<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.data);
            preorder(list, root.left);
            preorder(list, root.right);
        }
    }

    /**
     * recursively adds "*" between successive characters. ex. abba = ab*ba
     * 
     * <p>
     * o(n) Time
     * 
     * @param s
     * @return
     */
    public String insertStarPair(String s) {
        if (s == null || s.length() == 1) {
            return s;
        } else if (s.substring(0, 1).equals(s.substring(1, 2))) {
            return s.substring(0, 1) + "*" + insertStarPair(s.substring(1, s.length()));
        } else {
            return s.substring(0, 1) + insertStarPair(s.substring(1, s.length()));
        }

    }

    /**
     * This is another way to insert a node at the end of a linked list. I'm not
     * sure if this is any faster than the other way. The original way is in my
     * SinglyLinkedList class
     * 
     * <p>
     * O(n) Time and O(1) space
     * 
     * @param head
     * @return
     */
    public Node insertNode(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        Node fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
        }
        fast.getNext().setNext(new Node(data));
        return head;
    }

    /**
     * returns two indices whose values equal the target.
     * 
     * <p>
     * O(n) Time and Space
     * 
     * @param n
     * @param target
     * @return
     */
    public int[] coupleSum(int[] n, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n.length; i++) {
            if (map.get(n[i]) == null) {// the other way is to use map.containsKey(n[i])
                map.put(target - n[i], i + 1);
            } else {
                return new int[] { map.get(n[i]), i + 1 };
            }
        }
        return new int[] {};
    }

    /**
     * returns the binary string representation of a value using recursion
     * 
     * <p>
     * O(n) Time
     * 
     * @param value
     * @return
     */
    public String computerBinary(int value) {// or Integer.toBinaryString(Value)
        if (value < 2) {
            return Integer.toString(value);
        } else {
            return computerBinary(value / 2) + computerBinary(value % 2);
        }
    }

    /**
     * potential overflow solution to finding if a int is a palindrome only using
     * stack space
     * 
     * @param x
     * @return
     */
    public static Boolean isIntPalindrome(int x) {
        // Add your code below this line. Do not modify any other code.

        if (x < 0)
            return false;

        int rev = 0;
        int copy = x;

        while (copy > 0) {
            rev = rev * 10 + copy % 10; // the copy %10 can be stored in a variable remainder
            copy = copy / 10;
        }

        return rev == x;
    }

    // non over-flow solution
    // public static Boolean isIntPalindrome(int x) {

    // if (x<0) return false;

    // if (x==0) return true;

    // int div=1;

    // while(x/div>=10)
    // div = div*10;

    // while(x!=0)
    // {
    // int l = x/div;
    // int r = x%10;

    // if (l!=r) return false;

    // x = (x%div)/10;
    // div = div/100;

    // }

    // return true;

    // }

    /**
     * deletes the "tail" node of a circularly linked list
     * 
     * <p>
     * O(n) Time and O(1) Space
     * 
     * @param head
     * @return
     */
    public Node deleteAtTail(Node head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        Node curr = head;
        Node prev = head;

        while (curr.getNext() != head) {
            prev = head;
            curr = curr.getNext();
        }
        prev.setNext(curr.getNext());// or set it to head
        curr.setNext(null);
        curr = null;
        return head;
    }

    /**
     * Similar to anagrams solution and you can actually use that solution here, but
     * this is constrained to linear Time and constant space, and you're given
     * lowercase inputs, so you're not technically constrained to that, but you
     * should use as less space as possible.
     * 
     * <p>
     * Determine if the two lowercase inputs are anagrams of each other. An anagram
     * is a string that is formed from re-arranging the letters, using each letter
     * exactly once. Ex. 'abced' is an anagram of 'abcde'
     * 
     * <p>
     * The first solution I came up for this was to switch the end letter to the
     * front and append the rest of the string and check if the two strings were
     * equal, but that was due to me not understanding what an anagram actually was
     * and the examples being misleading.
     * 
     * <p>
     * O(n) Time and O(1) Space
     * 
     * @param one
     * @param two
     * @return
     */
    public boolean isAnagram(String one, String two) {
        if (one == null || two == null || one.length() != two.length()) {
            return false;
        }
        int[] letters = new int[26];

        for (int i = 0; i < one.length(); i++) {
            letters[one.charAt(i - 'a')]++;
            letters[two.charAt(i) - 'a']--;
        }
        for (int i = 0; i < letters.length; i++) {
            int e = letters[i];
            if (e != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * adds a new node to the front of a linked list. This was stolen from my
     * SinglyLinkedList class, but it's the same implementation. I just didn't check
     * for nulls in this implementation which is cleaner, nor do I return the head.
     * That problem asks for the head.
     * 
     * <p>
     * O(1) Time and Space
     * 
     * @param node
     */
    public void pushFront(Node head, Node node) {
        node.setNext(head);
        head = node;
        // nodeCount++;
    }

    /**
     * checks whether a given linked list have an even or odd number of nodes
     * 
     * O(n) Time and O(1) Space;
     * 
     * @param head
     * @return
     */
    public boolean isListEven(Node head) {
        if (head == null) {
            return true;
        }
        Node curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.getNext();
        }

        if (count % 2 == 0) {
            return true;
        } else {
            return false;
        }

        /*
         * alternate implementation Node curr = head; while(curr!=null){
         * if(curr.next!=null){ curr=curr.next.next; }else{ break; } } if(curr==null){
         * return true; }else{ return false; }
         */
    }

    /**
     * find a node with the specified value without using recursion
     * 
     * <p>
     * O(n) Time and Space
     * 
     * @param root
     * @param val
     * @return
     */
    public TreeNode findNode(TreeNode root, int val) {
        if (root == null)
            return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode curr = null;
        while (!q.isEmpty()) {
            curr = q.remove();
            if (curr.data == val) {
                return curr;
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return null;
    }

    /**
     * count the number of leaves in a tree
     * <p>
     * non-recursive way
     * <br>
     * <p>
     * O(n) Time and Space
     * 
     * <p>
     * recursive way
     * <br>
     * <p>
     * O(n) Time and O(log n) Space - recursion overhead in average case
     * 
     * @param root
     * @return
     */
    public int numberOfLeaves(TreeNode root){
        if(root==null) return 0;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode curr = null;
        int count=0;

        ArrayList<Integer> s = new ArrayList<>();
        //q.
        while(!q.isEmpty()){
            curr = q.poll();

            if(curr.left==null&&curr.right==null){
                count++;
            }else{
                if(curr.left!=null){
                    q.add(curr.left);
                }if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return count;

        /*
        * recursive way

        public int findLeaves(TreeNode root){
            if (root==null) return 0;

            if(root.right==null&&root.left==null){
                return 1;
            }else{
                return findLeaves(root.left)+findLeaves(root.right);
            }
        }
        */
    }

    /**
     * preorder traversal of a tree iteratively
     * 
     * <p>
     * O(n) Time and Space
     * 
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderItr(TreeNode root) {
        ArrayList<Integer> preorderList = new ArrayList<>();
        LinkedList<TreeNode> s = new LinkedList<>();

        if (root == null)
            return preorderList;
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            preorderList.add(root.data);

            if (root.right != null)
                s.push(root.right);
            if (root.left != null)
                s.push(root.left);
        }

        return preorderList;
    }

    /**
     * reverse an integer
     * 
     * <p>
     * O(n) Time
     * 
     * @param num
     * @return
     */
    public int reverseInt(int num) {
        int remainder = num;
        int rev = 0;

        while (remainder / 10 != 0) {
            rev = remainder % 10;
            rev *= 10;
            remainder /= 10;
        }
        rev += remainder;
        return rev;

        /*
         * or int rev=0; while(x!=0){ rev = rev*10 + x%10; x/=10; } return rev;
         */
    }

    /**
     * transpose a 2D matrix in place;
     * 
     * <p>
     * O(n) Time and O(1) Space
     * <p>
     * Explanation: This O(n) time complexity because in the worst case we have to
     * transpose every element once so in a 10x10 matrix that would be 100
     * transpositions. This would only be O(n^2) if for every element in the matrix
     * we were transposing it with every element in the matrix
     * 
     * @param matrix
     */
    public void transpose(int[][] matrix) {
        int temp = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix[0].length; col++) {
                temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }

        }
    }

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int data) {
            this.data = data;
        }
    }
}