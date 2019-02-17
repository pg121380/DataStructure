package sort;

/**
 * 本类中封装了一些关于排序所需要的辅助方法（默认情况下按由小到大排序）
 */
public class SortAssist {
    /**
     * 判断参数a是否小于参数b
     * @param a
     * @param b
     * @return
     */
    public static boolean less(int a, int b){
        return a < b;
    }

    /**
     * 交换数组array的第i项和第j项
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean isSorted(int[] array){
        for (int i = 1; i < array.length; i++) {
            if(less(array[i], array[i - 1])){
                return false;
            }
        }
        return true;
    }

    public static int[] getUnsortedArray(int length){
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random() * 1000);
        }
        return array;
    }

    public static void showArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
