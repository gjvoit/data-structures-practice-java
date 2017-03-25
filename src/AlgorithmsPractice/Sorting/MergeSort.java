package AlgorithmsPractice.Sorting;

/**
 * Created by garetvoit on 3/23/17.
 * Credit to https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/MergeSort.java
 * While I have renamed some variables for my own clarity, I am just leveraging an existing implementation to refresh my understanding of MergeSort.
 * Time Complexity: O(n(log(n))
 * Space Complexity: O(n)
 * Algorithm attributes: Stable, NOT in-place
 */

import java.util.*;

public class MergeSort
{
    public static void main(String[] args)
    {
        Integer[] a = {2, 6, 3, 5, 1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(Comparable [ ] a)
    {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }


    private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
            System.out.println(Arrays.toString(tmp));
            System.out.println(Arrays.toString(a));
        }
    }


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int tmpIterator = left;
        int numElementsToCopy = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[tmpIterator++] = a[left++];
            else
                tmp[tmpIterator++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[tmpIterator++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[tmpIterator++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < numElementsToCopy; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}