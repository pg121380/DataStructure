package sort;

public class MergeSort {

    private static int[] assistArray;

    private static void merge(int[] array, int low, int middle, int high){
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            assistArray[k] = array[k];
        }
        for (int k = low; k <= high; k++) {
            if(i > middle){
                array[k] = assistArray[j++];
            } else if(j > high){
                array[k] = assistArray[i++];
            } else if(SortAssist.less(assistArray[j], assistArray[i])){
                array[k] = assistArray[j++];
            } else {
                array[k] = assistArray[i++];
            }
        }
    }

    private static void sort(int[] array, int low, int high){
        if(high <= low){
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array,mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void sort(int[] array){
        assistArray = new int[array.length];
        sort(array, 0, array.length - 1);
    }
}
