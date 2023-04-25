package com.quickSort;

public class QuickSort {


    public static void main(String[] args) {
        int[] array = {7, 23, 3, 54, 5, 8, 10};
        sort(array, 0, array.length - 1);
        System.out.println(array);
    }

    public static void sort(int[] arrays, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arrays[left];
        int temp = 0;
        while (l < r) {
            while (pivot <= arrays[r] && l < r) {
                r--;
            }
            while (pivot >= arrays[l] && l < r) {
                l++;
            }
            if (l <= r) {
                temp = arrays[r];
                arrays[r] = arrays[l];
                arrays[l] = temp;
            }
        }
        arrays[left] = arrays[l];
        arrays[l] = pivot;
        sort(arrays, left, l - 1);
        sort(arrays, l + 1, right);
    }
}
