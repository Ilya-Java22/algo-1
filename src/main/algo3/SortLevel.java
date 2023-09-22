package main.algo3;

public class SortLevel
{
    public static void SelectionSortStep( int array[], int i )
    {
            int minElementIndex = i;
            int currentMinElement = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < currentMinElement) {
                    minElementIndex = j;
                }
            }
            swap(array, minElementIndex, i);
    }

    public static boolean BubbleSortStep( int array[] )
    {
        boolean swappingOccured = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                swappingOccured = true;
            }
        }
        return swappingOccured;
    }

    private static void swap(int[] array, int in, int in1) {
        int temp = array[in];
        array[in] = array[in1];
        array[in1] = temp;
    }
}