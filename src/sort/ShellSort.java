package sort;

public class ShellSort extends Sorter {
    @Override
    public void sort(int[] array) {
        int N = array.length;
        int h = 1;
        while(h < N / 3){
            h = 3 * h + 1;
        }
        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]) ; j-=h) {
                    exchange(array, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
