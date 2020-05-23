package dsa.app;

import dsa.codepractice.firecode.Level2;

/**
 * Application runner
 * 
 * @author Chavoris
 *
 */
public class App {
    public static void main(String[] args) {
        Level2 l2 = new Level2();
        String a = l2.compressText("abcefgggggggghhhhhhhhhhhh");
        System.out.println(a);
    }
}
