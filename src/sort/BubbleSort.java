package sort;

public class BubbleSort {
    public static void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(!SortAssist.less(array[j], array[j + 1])){
                    SortAssist.exchange(array, j, j + 1);
                }
            }
        }
    }
}
