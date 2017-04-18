package PracticeQuestions.HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Garet on 4/14/2017.
 */
public class HashMaps {
    public LinkedList<Character> findGroups(HashMap<Character, HashSet<Character>> hmap, Character user) {
        LinkedList<Character> result = new LinkedList<Character>();
        for (Character c : hmap.keySet()) {
            if (hmap.get(c).contains(user)) result.addLast(c);
        }
        return result;
    }
}
