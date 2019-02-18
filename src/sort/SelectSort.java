package sort;

public class SelectSort {
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if(SortAssist.less(array[j], array[min])){
                    min = j;
                }
            }
            SortAssist.exchange(array, i, min);
        }
    }
}
