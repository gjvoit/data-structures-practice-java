package PracticeQuestions.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Garet on 3/11/2017.
 */
public class ArraysAndStrings {
    /* 1.1
     * Return false if any duplicate is found in the string else return true
     * Brute force is two nested for loops, resulting in Space Complexity: O(1), Time Complexity: O(n^2)
     */
    public boolean isUniqueBruteForce(String checkString) {
        if (checkString.length() < 2) return true;
        for (int i=0; i < checkString.length(); i++) {
            for (int j = 0; j < checkString.length(); j++) {
                if (i == j) continue;
                else if (checkString.charAt(i) == checkString.charAt(j)) return false;
            }
        }
        return true;
    }
    /* To optimize for time, we could use a dictionary (HashMap) of all characters that the String contains
     * This would result in Space Complexity: O(n), Time Complexity: O(n)
     */
    public boolean isUniqueSpaceOptimized(String checkString) {
        if (checkString.length() < 2) return true;
        HashMap<String, String> dict = new HashMap();
        for (int i=0; i < checkString.length(); i++) {
            if (dict.get(checkString.substring(i,i+1)) != null) return false;
            else dict.put(checkString.substring(i,i+1), checkString.substring(i,i+1));
        }
        return true;
    }

    /* 1.2
     * checkPermutation
     * Return true if two strings are permutations of one another, otherwise false.
     * Brute force has Space Complexity O(1), Time Complexity O(n^2) (technically O(a*b), but assume identical length,
     * since they would otherwise not be permutations of one another).
     * Easy optimization is to sort both strings, which would reduce us to O(n+2(log(n))) which reduces Time Complexity
     * to O(n) with Space Complexity remaining O(1)
     */
    public boolean checkPermutation(String a, String b) {
        // Java doesn't have a default sort method for String... rude.
        return true;
    }

    /* 1.3
     * URLify
     * Given a char[] with " ", return char[] that replaces all " " with %20
     * Space Complexity: O(1)
     * Time Complexity: O(2n)
     * Code complexity could be reduced to O(n) if allowed to use a second char[]
     */
    public char[] URLify(char[] input, int length) {
        int numSpaces = 0;
        for (int i=0; i<length-1; i++) {
            if (input[i] == ' ') numSpaces++;
        }
        int insertIndex = length + numSpaces*2 - 1;
        for (int j=length-1; j > 0; j--) {
            if (input[j] == ' ') {
                input[insertIndex] = '0';
                input[insertIndex-1] = '2';
                input[insertIndex-2] = '%';
                insertIndex-=3;
            }
            else {
                input[insertIndex] = input[j];
                insertIndex-=1;
            }
        }
        return input;
    }

}
