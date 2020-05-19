package dsa.codepractice.firecode;

import java.util.HashSet;

public class Level1 {

    // public static void flipItVerticalAxis(int[][] matrix) {
    //     int[][] newM;
    //     for (int r = 0; r < matrix[r].length; r++) {
    //         for (int c = matrix[r][c].length; c > 0; c--) {
    //             newM[r][c] = matrix[r][c];
    //         }
    //     }
    // }

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
    
}