package PracticeQuestions.ArraysAndStrings;

/**
 * Created by Garet on 3/11/2017.
 */
public class ArraysAndStringsImpl {
    public static void main(String[] args) {
        ArraysAndStrings tester = new ArraysAndStrings();
        /*System.out.println(tester.isUniqueBruteForce(""));
        System.out.println(tester.isUniqueSpaceOptimized("abcdefghijklmnopqrstuvwxyz1234567890."));
        char[] input = new char[15];
        input[0] = 'a'; input[1] = 'b'; input[2] = ' '; input[3] = 'c'; input[4] = 'd'; input[5] = ' '; input[6] = 'e';
        System.out.println(tester.URLify(input, 7));
        */
        String a = "abccda";
        String b = "aabbde";
//        System.out.println(tester.checkPermutation(a, b));
        System.out.println(tester.containsPalindromePermutation(b));
        int[] costsA = {9, 5, 2, 5, 1, 10, 8};
        System.out.println(tester.calculateMaxProfit(costsA));

    }
}
