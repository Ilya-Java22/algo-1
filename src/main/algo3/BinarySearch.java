package main.algo3;

public class BinarySearch {
    public int Left;
    public int Right;
    public int[] array;
    private int searchingStatus;
    private boolean searchingIsOver;

    public BinarySearch(int[] array) {
        Left = 0;
        Right = array.length - 1;
        this.array = array;
    }

    public void Step(int N) {
        if (searchingIsOver) {
            Left = 0;
            Right = array.length - 1;
            searchingIsOver = false;
        }
        int mid = (Left + Right) / 2;
        if (array[mid] == N) {
            searchingStatus = 1;
            searchingIsOver = true;
            return;
        }
        if (N < array[mid]) {
            Right = mid - 1;
        } else {
            Left = mid + 1;
        }
        if (Left - Right > 0) {
            searchingStatus = -1;
            searchingIsOver = true;
            return;
        }
        searchingStatus = 0;
    }

    public int GetResult() {
        return searchingStatus;
    }
}
