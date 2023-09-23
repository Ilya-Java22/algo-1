package main.algo3;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static int ArrayChunk( int[] M ) {
        while(true) {
            int N = M[M.length / 2];
            int indexN = M.length / 2;
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
                    break;
                }
                if (i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2])) {
                    return indexN;
                }
                swap(M, i1, i2);
                if (i1 == indexN) {
                    indexN = i2;
                }
                if (i2 == indexN) {
                    indexN = i1;
                }
            }
        }

    }

    private static void swap(int[] array, int in, int in1) {
        int temp = array[in];
        array[in] = array[in1];
        array[in1] = temp;
    }
}