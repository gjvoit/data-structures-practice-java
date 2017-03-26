package AlgorithmsPractice.Knapsack;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by garetvoit on 3/26/17.
 */
public class Knapsack {

    public static void main (String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./src/AlgorithmsPractice/Knapsack/input.txt"));
        int numTests = Integer.parseInt(scanner.nextLine()); // Scans the next token of the input as an int.
        System.out.println(numTests);
        for (int i = 0; i < numTests; i++) {

            // Read in size of array
            int numObjects = Integer.parseInt(scanner.nextLine());
            System.out.println("The number of objects: " + numObjects);

            // Read in maximum weight
            int maxWeight = Integer.parseInt(scanner.nextLine());
            System.out.println("The maximum weight allowed: " + maxWeight);

            // Read in values array
            String[] valuesInput = scanner.nextLine().split(" ");
            Integer[] values = new Integer[valuesInput.length];
            for (int j = 0; j < valuesInput.length; j++) {
                values[j] = Integer.parseInt(valuesInput[j]);
            }
            System.out.println("values:  " + Arrays.toString(values));

            // Read in weights array
            String[] weightsInput = scanner.nextLine().split(" ");
            Integer[] weights = new Integer[weightsInput.length];
            for (int j = 0; j < weightsInput.length; j++) {
                weights[j] = Integer.parseInt(weightsInput[j]);
            }
            System.out.println("weights: " + Arrays.toString(weights));

            // Inputs read in, execute algorithm for this test case
            Knapsack computeKnapsack = new Knapsack();
            System.out.println(computeKnapsack.recursiveInPlaceSolution(numObjects, maxWeight, values, weights));
            System.out.println(computeKnapsack.dynamicProgrammingSolution(numObjects, maxWeight, values, weights));
        }
    }

    private int getMax(int x, int y) { return x > y ? x : y; }

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     * @param n the number of items being considered for this iteration.
     * @param W the max weight. The combined weights of our optimal set of items must be less than or equal to this weight.
     * @param values An array whose length is equal to numObjects which contains the values for all items.
     * @param weights An array whose length is equal to numObjects which contains the weights for all items.
     * @return The optimal value achievable from the given value/weight pairings and maxWeight.
     */
    private int recursiveInPlaceSolution(int n, int W, Integer[] values, Integer[] weights) {
        if (n == 0 || W == 0) return 0;

        if (weights[n-1] > W)
            return recursiveInPlaceSolution(n-1, W, values, weights);
        else return getMax(
                values[n - 1] + recursiveInPlaceSolution(n - 1, W - weights[n - 1], values, weights),
                recursiveInPlaceSolution(n - 1, W, values, weights)
        );
    }


    /**
     * Time Complexity: O(n*W)
     * Space Complexity: O(n*W)
     * @param n the number of total objects.
     * @param W The maximum weight.
     * @param values An array whose length is equal to numObjects which contains the values for all items.
     * @param weights An array whose length is equal to numObjects which contains the weights for all items.
     * @return The optimal value achievable from the given value/weight pairings and maxWeight.
     */
    private int dynamicProgrammingSolution(int n, int W, Integer[] values, Integer[] weights) {
        // i will correspond to iterating numItems from 0 to n
        // j will correspond to iterating maxWeight from 0 to W
        int i, j;
        // Create a 2d array of size n*W
        int[][] knownMaximums = new int[n+1][W+1];
        for (i=0; i <= n; i++) {
            for (j=0; j <= W; j++) {
                // If either numItems (i) or maxWeight (j) is 0, we know our solution is 0 for that iteration, since no items can be added to this subset.
                if (i == 0 || j == 0) knownMaximums[i][j] = 0;
                else if (weights[i-1] <= j) knownMaximums[i][j] = getMax(values[i-1] + knownMaximums[i-1][j-weights[i-1]],
                        knownMaximums[i-1][j]
                );
                else knownMaximums[i][j] = knownMaximums[i-1][j];
            }
        }
        return knownMaximums[n][W];
    }
}
