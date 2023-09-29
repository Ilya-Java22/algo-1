package main.algo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortLevel
{
    public static void SelectionSortStep( int array[], int i )
    {
            int minElementIndex = i;
            int currentMinElement = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < currentMinElement) {
                    minElementIndex = j;
                    currentMinElement = array[j];
                }
            }
            swap(array, minElementIndex, i);
    }

    public static boolean BubbleSortStep( int array[] )
    {
        boolean swappingAbsent = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                swappingAbsent = false;
            }
        }
        return swappingAbsent;
    }

    public static void InsertionSortStep( int[] array, int step, int i )
    {
        int[] elementsSelection = new int[(array.length - 1 - i) / step + 1];
        for (int j = i, k = 0; j < array.length; j += step) {
            elementsSelection[k++] = array[j];
        }
        Arrays.sort(elementsSelection);
        for (int j = i, k = 0; j < array.length; j += step) {
            array[j] = elementsSelection[k++];
        }   
    }

    public static ArrayList<Integer> KnuthSequence(int array_size ) {
        int lengthKnuthSequence = (int) (Math.log((2.0 * array_size + 1) / 3) / Math.log(3)) + 1;
        ArrayList<Integer> result = new ArrayList<>(lengthKnuthSequence);
        for (int i = 0; i < lengthKnuthSequence; i++) {
            int currentElement = i == 0 ? 1 : 3 * result.get(0) + 1;
            result.add(0, currentElement);
        }
        return result;
    }

    public static void Shell(int[] M) {
        ArrayList<Integer> knuthSequence = KnuthSequence(M.length);
        for (int i = 0; i < knuthSequence.size(); i++) {
            for (int j = 0; j < knuthSequence.get(i); j++) {
                InsertionSortStep(M, knuthSequence.get(i), j);
            }
        }
    }

    public static int ArrayChunk( int[] M ) {
        int indexN = M.length / 2;
        int N = M[indexN];
        int i1 = 0;
        int i2 = M.length - 1;
        while(true) {
            while(M[i1] < N) {
                i1++;
            }
            while(M[i2] > N) {
                i2--;
            }
            if (i1 == i2 - 1 && M[i1] > M[i2]) {
                swap(M, i1, i2);
                return ArrayChunk(M);
            }
            if (i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2])) {
                return indexN;
            }
            swap(M, i1, i2);
            if (indexN == i1 || indexN == i2) {
                indexN = indexN == i1 ? i2 : i1;
            }
        }
    }

    //моё
    public static int ArrayChunk2( int[] M, int left, int right) {
        int indexN = (left + right) / 2;
        int N = M[(left + right) / 2];
        int i1 = 0;
        int i2 = M.length - 1;
        while(true) {
            while(M[i1] < N) {
                i1++;
            }
            while(M[i2] > N) {
                i2--;
            }
            if (i1 == i2 - 1 && M[i1] > M[i2]) {
                swap(M, i1, i2);
                return ArrayChunk2(M, left, right);
            }
            if (i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2])) {
                return indexN;
            }
            swap(M, i1, i2);
            if (indexN == i1 || indexN == i2) {
                indexN = indexN == i1 ? i2 : i1;
            }
        }
    }

    //моё
    public static void SimplifiedChunkQuickSort( int[] array, int left, int right ) {
        if (left < right) {
            int refIndex = ArrayChunk2(array, left, right);
            QuickSort(array, left, refIndex - 1);
            QuickSort(array, refIndex + 1, right);
        }
    }

    public static void QuickSort( int[] array, int left, int right ) {
        if (left < right) {
            int[] newArray = Arrays.copyOfRange(array, left, right + 1);
            int refIndex = ArrayChunk(newArray) + left;
            System.arraycopy(newArray, 0, array, left, right + 1 - left);
            QuickSort(array, left, refIndex - 1);
            QuickSort(array, refIndex + 1, right);
        }
    }

    public static void QuickSortTailOptimization( int[] array, int left, int right ) {
        while (left < right) {
            int[] newArray = Arrays.copyOfRange(array, left, right + 1);
            int refIndex = ArrayChunk(newArray) + left;
            System.arraycopy(newArray, 0, array, left, right + 1 - left);
            QuickSortTailOptimization(array, left, refIndex - 1);
            left = refIndex + 1;
        }
    }

    public static ArrayList<Integer> KthOrderStatisticsStep( int[] Array, int L, int R, int k ) {
        int N = ArrayChunk2(Array, L, R);
        if (k > N) {
            L = N + 1;
        }
        if (k < N) {
            R = N - 1;
        }
        return new ArrayList<>(Arrays.asList(L, R));
    }

    //моё
    public static int KthOrderStatistics( int[] Array, int L, int R, int k ) {
        int N = ArrayChunk2(Array, L, R);
        if (k == N) {
            return Array[N];
        }
        if (k > N) {
            L = N + 1;
        }
        if (k < N) {
            R = N - 1;
        }
        return KthOrderStatistics(Array, L, R, k);
    }

    //плохой демонстрационно-учебный вариант
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> arrayList) {
        return IntroMergeSort(arrayList, 0, arrayList.size() - 1);
    }

    private static ArrayList<Integer> IntroMergeSort(ArrayList<Integer> arrayList, int from, int to) {
        if (from == to) {
            return new ArrayList<>(List.of(arrayList.get(from)));
        }
        int mid = (from + to) / 2;
        ArrayList<Integer> leftSublist = IntroMergeSort(arrayList, from, mid);
        ArrayList<Integer> rightSublist = IntroMergeSort(arrayList, mid + 1, to);
        ArrayList<Integer> resultList = new ArrayList<>();
        while (!leftSublist.isEmpty() && !rightSublist.isEmpty()) {
            int leftSublistElement = leftSublist.get(0);
            int rightSublistElement = rightSublist.get(0);
            if (leftSublistElement <= rightSublistElement) {
                resultList.add(leftSublistElement);
                leftSublist.remove(0);
                continue;
            }
            resultList.add(rightSublistElement);
            rightSublist.remove(0);
        }
        resultList.addAll(leftSublist);
        resultList.addAll(rightSublist);
        return resultList;
    }

    private static void swap(int[] array, int in, int in1) {
        int temp = array[in];
        array[in] = array[in1];
        array[in1] = temp;
    }
}