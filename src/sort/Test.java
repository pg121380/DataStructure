package sort;

public class Test {
    public static void main(String[] args) {
        Sorter sorter = new ShellSort();
        int[] array = sorter.getUnsortedArray(50);
        sorter.showArray(array);
        sorter.sort(array);
        System.out.println(sorter.isSorted(array));
        System.out.println("-------------------------------");
        sorter.showArray(array);
    }
}
