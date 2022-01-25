package dsa.app;

import dsa.codepractice.firecode.Level3;

/**
 * Application runner
 * 
 * @author Chavoris
 *
 */
public class App {
    public static void main(String[] args) {
        // System.out.println("Hello World");
        // Level3 l3 = new Level3();
        // int max = l3.getMaxRepetition(null);
        // System.out.println(max);
        String b = "abc000123";
        String[] s = b.split("\\d");
        b = b.replaceAll("[a-zA-z^0]", "");
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
        System.out.println(b);
        //system.println("abc");
    }
}
