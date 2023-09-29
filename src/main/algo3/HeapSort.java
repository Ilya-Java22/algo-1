package main.algo3;

import main.heap.Heap;

public class HeapSort {
    public Heap HeapObject = new Heap();

    public HeapSort(int[] array) {
        HeapObject.MakeHeap(array, (int)(Math.log(array.length) / Math.log(2)));
    }

    public int GetNextMax() {
        return HeapObject.GetMax();
    }
}
