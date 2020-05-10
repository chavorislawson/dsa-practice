package dsa.codepractice.firecode;

public class Level1 {

    /**
     * returns fibonacci sequence up to n
     * 
     * @param n
     * @return
     */
    public int fib(int n){
        return n<2 ? n : fib(n-1)+fib(n-2);
    }

    // public static void flipItVerticalAxis(int[][] matrix) {
    //     int[][] newM;
    //     for (int r = 0; r < matrix[r].length; r++) {
    //         for (int c = matrix[r][c].length; c > 0; c--) {
    //             newM[r][c] = matrix[r][c];
    //         }
    //     }
    // }
}