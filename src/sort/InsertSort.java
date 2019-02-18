package sort;

public class InsertSort {
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && SortAssist.less(array[j], array[j - 1]) ; j--) {
                SortAssist.exchange(array, j, j - 1);
            }
        }
    }
}
