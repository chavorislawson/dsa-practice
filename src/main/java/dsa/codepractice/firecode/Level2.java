package dsa.codepractice.firecode;

import java.util.HashMap;

import dsa.datastructures.linkedList.Node;

public class Level2 {

    /**
     * are they the same length?
     * are they the same case?
     * do they contain letters?
     * are they empty?
     * is each letter in one in two?
     * 
     * time complexity: O(n) linear
     * space complexity: O(1) Constant
     * 
     * @param one
     * @param two
     * @return
     */
    public boolean permutation(String one, String two) {

        if (one.length() != two.length()) {
            return false;
        }
        int[] letters = new int[256];// because there are 256 ASCII characters. Not common sense, but it's common knowledge.
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
    public int findMax(TreeNode root){
        int rtd = Integer.MIN_VALUE, ld = Integer.MIN_VALUE,rd = Integer.MIN_VALUE, max=Integer.MIN_VALUE;
        ld = 0; rtd =0; rd=0;
        if(root!=null){
            rtd = root.data;
            ld = findMax(root.left);
            rd = findMax(root.right);
            if(ld>rd){
                max=ld;
            }else{
                max=rd;
            }
            if(rtd>max){
                max=rtd;
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
     * @param root
     * @return
     */
    public int size(TreeNode root){
        return root == null ? 0 : size(root.right)+1+size(root.left);
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
    public boolean validateBST(TreeNode root){
        return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     * helper function to determine if tree is Binary Search Tree
     * 
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean validateBST(TreeNode root, int min, int max){
        if(root==null){
            return true;
        }if(root.data<=min||root.data>=max){
            return false;
        }
        return validateBST(root.left,min,root.data)&&validateBST(root.right, root.data, max);
    }

    /**
     * <p>
     * Checks if two strings are isomorphic of each other. This needs further explanation.
     * 
     * <p>
     * O(n) space and time;
     * 
     * @param one
     * @param two
     * @return
     */
    public boolean isIsomorphic(String one, String two){
        if(one.length()<two.length()||two.isEmpty()){
            return true;
        }
        HashMap<Character, Integer> o = new HashMap<>();
        HashMap<Character, Integer> t = new HashMap<>();

        for(int i=0;i<two.length();i++){
            char c1 = one.charAt(i);
            int val1 = o.get(c1)==null ? 1 : o.get(c1)+1;
            o.put(c1,val1);

            char c2 = two.charAt(i);
            int val2 = t.get(c2)==null ? 1 : t.get(c2)+1;
            t.put(c2,val2);

            if(!o.get(c1).equals(t.get(c2))){
                return false;
            }

        }
        return true;
    }

    /**
	 * removes node at specified index +
	 * 
	 * @param index
	 * @return
	 */
	public Node remove(Node head,int index){
		if(index==1){
			return head==null ? head : head.getNext(); 
		}
		Node curr = head;
		Node prev = head;

		while(curr.getNext()!=null){
			--index;
			if(index==0){
				prev.setNext(curr.getNext());
				curr = null;
			}
			prev=curr;
			curr=curr.getNext();
		}
		return head;
	}

    public class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    }
}