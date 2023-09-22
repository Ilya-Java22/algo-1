package main.algo3;

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

    private static void swap(int[] array, int in, int in1) {
        int temp = array[in];
        array[in] = array[in1];
        array[in1] = temp;
    }
}