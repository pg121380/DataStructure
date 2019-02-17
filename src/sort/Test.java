package sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        testBubble();
    }

    public static void testBubble(){
        int[] array = SortAssist.getUnsortedArray(10);
        BubbleSort.sort(array);
        SortAssist.showArray(array);
    }

    @org.junit.Test
    public void compareSpeed(){
        int[] arrayForMerge = SortAssist.getUnsortedArray(100000);
        int[] arrayForQuick = Arrays.copyOf(arrayForMerge, arrayForMerge.length);
        int[] arrayForBubble = Arrays.copyOf(arrayForMerge, arrayForMerge.length);

        long mergeStartTime = System.currentTimeMillis();
        MergeSort.sort(arrayForMerge);
        long mergeEndTime = System.currentTimeMillis();

        long quickStartTime = System.currentTimeMillis();
        QuickSort.sort(arrayForQuick);
        long quickEndTime = System.currentTimeMillis();

        long bubbleStartTime = System.currentTimeMillis();
        BubbleSort.sort(arrayForBubble);
        long bubbleEndTime = System.currentTimeMillis();

        System.out.println("归并排序：" + (mergeEndTime - mergeStartTime));
        System.out.println("快速排序：" + (quickEndTime - quickStartTime));
        System.out.println("冒泡排序：" + (bubbleEndTime - bubbleStartTime));
    }

    @org.junit.Test
    public void test(){
        System.out.println("hello world");
    }
}
