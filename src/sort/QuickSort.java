package sort;

public class QuickSort  {
    private static int partition(int[] array, int low, int high){
        int i = low;
        int j = high + 1;
        int v = array[low];

        while(true){
            while(SortAssist.less(array[++i], v)){
                if(i == high){
                    break;
                }
            }

            while(SortAssist.less(v,array[--j])){
                if(j == low){
                    break;
                }
            }

            if(i >= j){
                break;
            }
            SortAssist.exchange(array, i, j);
        }
        SortAssist.exchange(array, low, j);
        return j;
    }

    private static void sort(int[] array, int low, int high){
        if(high <= low){
            return ;
        }
        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }

    public static void sort(int[] array){
        sort(array, 0, array.length - 1);
    }
}
