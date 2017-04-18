package PracticeQuestions.HashMaps;

import PracticeQuestions.Playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Garet on 4/14/2017.
 */
public class HashMapsImpl {
    public static void main(String[] args) {
        HashMap<Character, HashSet<Character>> hmap = new HashMap<Character, HashSet<Character>>() {{
            put('x', new HashSet<Character>(Arrays.asList('a', 'b', 'c', 'y')));
            put('y', new HashSet<Character>(Arrays.asList('b', 'c', 'x')));
            put('z', new HashSet<Character>(Arrays.asList('a', 'b', 'c', 'x')));
        }};
        hmap.values();
        Iterator<HashSet<Character>> valuesIter = hmap.values().iterator();
        Iterator<Character> keysIter = hmap.keySet().iterator();
        hmap.keySet();
        HashMaps hm = new HashMaps();
        System.out.println(hm.findGroups(hmap, 'a'));
    }
}
