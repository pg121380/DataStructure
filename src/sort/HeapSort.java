package sort;

import tree.Heap;

public class HeapSort {
    public static void sort(int[] array){
        Heap heap = new Heap(array.length, array);
        heap.buildHeap();
        for(int i = heap.getData().length - 1;i > 0;i--){
            SortAssist.exchange(heap.getData(), i, 0);
            heap.percDown(0, i - 1);
        }
    }
}
