package dsa.codepractice.firecode;

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
}