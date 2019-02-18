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
        int[] arrayForMerge = SortAssist.getUnsortedArray(5000);
        int[] arrayForQuick = Arrays.copyOf(arrayForMerge, arrayForMerge.length);
        int[] arrayForBubble = Arrays.copyOf(arrayForMerge, arrayForMerge.length);
        int[] arrayForSelect = Arrays.copyOf(arrayForMerge, arrayForMerge.length);
        int[] arrayForInsert = Arrays.copyOf(arrayForMerge, arrayForMerge.length);

        long mergeStartTime = System.currentTimeMillis();
        MergeSort.sort(arrayForMerge);
        long mergeEndTime = System.currentTimeMillis();
        System.out.println("归并排序：" + (mergeEndTime - mergeStartTime) + " ms");


        long quickStartTime = System.currentTimeMillis();
        QuickSort.sort(arrayForQuick);
        long quickEndTime = System.currentTimeMillis();
        System.out.println("快速排序：" + (quickEndTime - quickStartTime) + " ms");


        long bubbleStartTime = System.currentTimeMillis();
        BubbleSort.sort(arrayForBubble);
        long bubbleEndTime = System.currentTimeMillis();
        System.out.println("冒泡排序：" + (bubbleEndTime - bubbleStartTime) + " ms");


        long selectStartTime = System.currentTimeMillis();
        SelectSort.sort(arrayForSelect);
        long selectEndTime = System.currentTimeMillis();
        System.out.println("选择排序：" + (selectEndTime - selectStartTime) + " ms");


        long insertStartTime = System.currentTimeMillis();
        InsertSort.sort(arrayForInsert);
        long insertEndTime = System.currentTimeMillis();
        System.out.println("插入排序：" + (insertEndTime - insertStartTime) + " ms");
    }

    @org.junit.Test
    public void test(){
        System.out.println("hello world");
    }

    @org.junit.Test
    public void testSelect(){
        int[] array = SortAssist.getUnsortedArray(500);
        SelectSort.sort(array);
        System.out.println(SortAssist.isSorted(array));
    }

    @org.junit.Test
    public void testInsert(){
        int[] array = SortAssist.getUnsortedArray(500);
        InsertSort.sort(array);
        System.out.println(SortAssist.isSorted(array));
    }
}
