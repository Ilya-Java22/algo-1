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
        if (Left >= Right) {
            searchingStatus = Left == Right && array[Left] == N ? 1 : -1;
            return;
        }
        searchingStatus = 0;
    }

    public int GetResult() {
        return searchingStatus;
    }

    public boolean GallopingSearch(int[] array, int N) {
        searchingStatus = 0;
        int i = 1;
        int index;
        while ((index = (int) (Math.pow(2,i) - 2)) < array.length) {
            if (array[index] == N) {
                return true;
            }
            if (array[index] > N) {
                break;
            }
            i++;
        }
        Left = i == 1 ? 0 : (int) (Math.pow(2,i - 1) - 2) + 1;
        Right = index < array.length ? index : array.length - 1;
        while (searchingStatus == 0) {
            Step(N);
        }
        return searchingStatus == 1;
    }
}
