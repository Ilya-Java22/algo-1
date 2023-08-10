package main.heap;

import java.util.stream.IntStream;

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() { HeapArray = null; }
    private int lastFilledIndex;

    public void MakeHeap(int[] a, int depth)
    {
        HeapArray = IntStream.range(0, (int) Math.pow(2, depth + 1) - 1)
                .map(i -> i < a.length ? a[i] : -1)
                .toArray();
        lastFilledIndex = a.length - 1;
        for (int i = lastFilledIndex / 2; i >= 0; i--) {
            toShiftDown(i);
        }
    }

    public int GetMax() // вернуть значение корня и перестроить кучу
    {
        int heapExtremum = HeapArray[0];
        if (heapExtremum != -1) {
            HeapArray[0] = HeapArray[lastFilledIndex]; //////////
            HeapArray[lastFilledIndex] = -1;
            lastFilledIndex--;
            toShiftDown(0);
        }
        return heapExtremum;
    }

    private void toShiftDown(int i) {
        while (2 * i + 1 < lastFilledIndex) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int j = leftChild;
            if (rightChild < lastFilledIndex && HeapArray[rightChild] > HeapArray[leftChild]) {
                j = rightChild;
            }
            if (HeapArray[i] >= HeapArray[j]) {
                break;
            }
            int temp = HeapArray[i];
            HeapArray[i] = HeapArray[j];
            HeapArray[j] = temp;
            i = j;
        }
    }

    public boolean Add(int key)        // добавляем новый элемент key в кучу и перестраиваем её
    {
        int currentIndex = lastFilledIndex + 1;
        if (currentIndex >= HeapArray.length) {
            return false; // если куча вся заполнена
        }
        int parentIndex = (currentIndex - 1) / 2;
        while (currentIndex > 0 && HeapArray[parentIndex] < HeapArray[currentIndex])
        {
            int temp = HeapArray[currentIndex];
            HeapArray[currentIndex] = HeapArray[parentIndex];
            HeapArray[parentIndex] = temp;

            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
        lastFilledIndex++;
        return true;
    }
}
