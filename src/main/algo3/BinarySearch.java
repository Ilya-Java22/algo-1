package main.algo3;

public class BinarySearch {
    public int Left;
    public int Right;
    public int[] array;
    private int searchingStatus;


    public BinarySearch(int[] array) {
        Left = 0;
        Right = array.length - 1;
        this.array = array;
    }

    public void Step(int N) {
        int mid = (Left + Right) / 2;
        if (array[mid] == N) {
            searchingStatus = 1;
            return;
        }
        if (N < array[mid]) {
            Right = mid - 1;
        } else {
            Left = mid + 1;
        }
        searchingStatus = Left - Right > 0 ? -1 : 0;
    }

    public int GetResult() {
        return searchingStatus;
    }
}
