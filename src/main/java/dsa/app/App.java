package dsa.app;

// import java.util.Arrays;
 import java.util.List; //Interface
 import java.util.ArrayList;
// import java.util.Vector;//probably not going to use

//  import java.util.Set; //interface
//  import java.util.SortedSet; //interface
//  import java.util.NavigableSet; //interface
//  import java.util.Stack;//recommended to use Deque, but this is actually a class, so just used LinkedList
//  import java.util.Deque; //interface
//  import java.util.Queue; //interface
 import java.util.LinkedList;

// import java.util.Dictionary; //don't use. use map, basically use the hashstuff
// import java.util.Map; //interface
// import java.util.SortedMap; //interface
// import java.util.NavigableMap; //interface
// import java.util.Hashtable;
 import java.util.HashMap;
 import java.util.HashSet;
// import java.util.LinkedHashMap;
// import java.util.LinkedHashSet;
// import java.util.TreeMap;
// import java.util.TreeSet;
// import java.util.WeakHashMap;

import dsa.codepractice.firecode.Level2;
//import dsa.codepractice.firecode.Level2.TreeNode;
import dsa.datastructures.linkedList.Node;
import dsa.datastructures.linkedList.SinglyLinkedList;
import dsa.interview.Oracle;

// import java.util.Iterator; //interface
// import java.util.ListIterator; //interface
// import java.util.Enumeration; //recommended to use iterator, interface
// import java.util.Comparator; //interface
// import java.util.BitSet;

/**
 * Application runner
 * 
 * @author Chavoris
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Arrays arrays;
        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        // ArrayList<String> arrayList = new ArrayList<>();

        // Set<String> set = new HashSet<>(); //why would you use one of these implementations over the other.
        // HashSet<String> hashSet = new HashSet<>();

        // SinglyLinkedList sLinkedList = new SinglyLinkedList();
        // sLinkedList.pushFront(new Node(1));
        // sLinkedList.pushFront(new Node(2));
        // sLinkedList.pushFront(new Node(3));
        // sLinkedList.pushFront(new Node(4));
        // sLinkedList.pushFront(new Node(5));
        // sLinkedList.pushFront(new Node(6));
        // sLinkedList.pushFront(new Node(7));
        // sLinkedList.pushBack(new Node(8));
        // sLinkedList.pushBack(new Node(9));
        // sLinkedList.printList();
        // sLinkedList.getNodeCount();
        // sLinkedList.printList();

        //System.out.println(sLinkedList.findMiddle());
        //Level2 l2 = new Level2();
        //TreeNode t = l2.new TreeNode(1, l2.new TreeNode(2,l2.new TreeNode(4, null, null),l2.new TreeNode(5, null, null)),l2.new TreeNode(3,l2.new TreeNode(6, null, null),l2.new TreeNode(7, null, null)));
        //System.out.println(l2.findMax(t));

    //     TreeNode root = new TreeNode(1);
    // root.left = new TreeNode(8);
    // root.left.left = new TreeNode(2);
    // root.right = new TreeNode(4);
    // root.right.right = new TreeNode(17);

        Oracle o = new Oracle();
        int a = o.firstOccurence(new int[] {1,2,3,4,5,6,2,3});
        System.out.println(a);
    }
    //abcde,acdbe - true
    //yellow,llowey - true

}
