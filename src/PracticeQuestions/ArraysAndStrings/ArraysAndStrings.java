package PracticeQuestions.ArraysAndStrings;

/**
 * Created by Garet on 3/11/2017.
 */
public class ArraysAndStrings {
    // 1.1
    // Return false if any duplicate is found in the string else return true
    // Brute force is two nested for loops, resulting in Space Complexity: O(1), Time Complexity: O(n^2)
    // To optimize for time, we could use a dictionary (HashMap) of all possible chars that the String contains
    // This would result in Space Complexity: O(n), Time Complexity: O(n)
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

}
