package main.algo2.trees.balancetreearray;

import java.util.Arrays;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a)
    {
        int[] rsl = new int[a.length];
        Arrays.sort(a);
        divideAndConquer(a, rsl, 0, a.length - 1,  0);
        return rsl;
    }

    private static void divideAndConquer(int[] a, int[] rsl, int from, int to,  int index) {
        if (index >= a.length) {
            return;
        }
        if (from == to) {
            rsl[index] = a[from];
            return;
        }
        int mid = (from + to) / 2;
        rsl[index] = a[mid];
        divideAndConquer(a, rsl, from, mid, 2 * index + 1);
        divideAndConquer(a, rsl, mid + 1, to, 2 * index + 2);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(Arrays.toString(GenerateBBSTArray(a)));
    }
}
