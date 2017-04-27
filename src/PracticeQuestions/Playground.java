package PracticeQuestions;

import CustomDataStructures.HashTable.HashTable;

import java.util.*;

/**
 * Created by Garet on 4/14/2017.
 */
public class Playground {
    public static void main(String[] args) {
        Playground pg = new Playground();
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(5);
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        ht.keySet();
        ht.values();
        ht.entrySet();
    }

    void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index-1) {
            quickSort(arr, left, index-1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    void swap(int[] arr, int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

}
