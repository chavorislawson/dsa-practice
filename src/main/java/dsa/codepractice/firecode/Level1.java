package dsa.codepractice.firecode;

import java.util.Arrays;
import java.util.HashSet;

import dsa.datastructures.linkedList.Node;

public class Level1 {

    /**
     * flip a matrix on it's vertical axis in place
     * 
     * <p>
     * O(n) time and O(1) Space
     * @param matrix
     */
    public static void flipItVerticalAxis(int[][] matrix) {
        if(matrix==null) return;
        //some old solution I fixed
        // int[][] newM = new int[matrix.length][matrix[0].length];
        // for (int r = 0; r < matrix.length; r++) {
        //     for (int c = matrix[r].length-1; c > 0; c--) {
        //         newM[r][matrix[r].length-c+1] = matrix[r][c];
        //     }
        // }
        int temp = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1] = temp;
            }
        }
    }

    /**
     * determines if a string has unique character in it or not
     * 
     * <p>
     * Hashed solution
     * <br>
     * <p>
     * O(n) Space and O(n) Time
     * 
     * <p>
     * Array solution
     * <br>
     * <p>
     * O(1) Space and O(n) Time
     * 
     * @param str
     * @return
     */
    public boolean isUnique(String str){
        if(str==null||str.length()==0){
            return true;
        }
        HashSet<Character> h = new HashSet<>();

        for(int i=0;i<str.length();i++){
            if(h.contains(str.charAt(i))){
                return false;
            }else{
                h.add(str.charAt(i));
            }
     
        }
        return true;

        /*
        Array Solution

        public boolean isUnique(String str){
            if(str=null||str.length()==0){
                return true;
            }

            boolean bool = new boolean[256];

            for(int i=0;i<str.length();i++){
                if(boolean[(int) str.charAt(i)]){
                    return false;
                }else{
                    boolean[(int) str.charAt(i)]=true;
                }
            }
            return true;
        }

        My Super Simple Solution

        public boolean isUnique(String str){
            int[] chars = new int[256];

            for(int i=0;(str!=null&&i<str.length());i++){
                chars[str.charAt(i)]++;

                if(chars[str.charAt(i)]>0){
                    return false;
                }
            }
            return true;
        }
        */
    }

    /**
     * Reverse a String
     * 
     * <p>
     * O(n) Time and Space
     * 
     * @param str
     * @return
     */
    public String reverseString(String str){
        //StringBuilder solution (recommended way)
        if(str==null){
            return str;
        }
        StringBuilder out = new StringBuilder();

        for(int i=str.length()-1;i>=0;i--){
            out.append(str.charAt(i));
        }

        return out.toString();
        //My solution
        // if(str==null){
        //     return str;
        // }
        // String out ="";

        // for(int i=str.length()-1;i>=0;i--){
        //     out+= str.charAt(i);
        // }

        // return out;
    }
    
    /**
     * find duplicate numbers in an integer array and return the result as a String
     * 
     * <p>
     * O(n log n) Time and O(n) Space
     * 
     * @param arr
     * @return
     */
    public String findDuplicate(int[] arr){
        Arrays.sort(arr);
        HashSet<Integer> dups = new HashSet<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                dups.add(arr[i]);
            }
        }
        return dups.toString();
    }
    
    /**
     * find the middle node of a Singly Linked List
     * 
     * <p> O(n) Time and O(1) Space
     * 
     * @param head
     * @return
     */
    public Node findMiddleOfLinkedList(Node head){
        if(head==null) return null;

        Node slow = head;
        Node fast = head;

        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Find the missing number from an array of digits numbered 1-10.
     *
     * <p> O(n) Time O(1) Space
     *
     * @param arr
     * @return
     */
    public int findMissingNumber(int[] arr){
        int total=0;
        int arrTotal=0;
        for(int i=1;i<11;i++){
            total+=i;
        }
        for(int i=0;i<arr.length;i++){
            arrTotal+=arr[i];
        }

        return total-arrTotal;
    }
}