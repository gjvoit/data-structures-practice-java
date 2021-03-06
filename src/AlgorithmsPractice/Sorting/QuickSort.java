package AlgorithmsPractice.Sorting;

import java.util.Arrays;

/**
 * Created by garetvoit on 3/23/17.
 */
public class QuickSort  {
    private int[] numbers;

    public static void main(String[] args) {
        QuickSort quickSorter = new QuickSort();
        int[] testArray = new int[5];
        for (int i=0; i<5; i++ ) {
            testArray[i] = 5-i;
        }
        System.out.println(Arrays.toString(testArray));
        quickSorter.quicksort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public void quicksort(int[] values) {
        // check for empty or null array
        if (values==null || values.length==0){
            return;
        }
        this.numbers = values;
        quicksort(0, values.length - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot element
            // then skip this element and evaluate the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot element
            // then skip this element and evaluate the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can shift i and j in their respective directions
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
