package sort;

public class Test {
    public static void main(String[] args) {
        int[] array = SortAssist.getUnsortedArray(10);
        MergeSort.sort(array);
        if(SortAssist.isSorted(array)){
            System.out.println("排序成功");
        } else {
            System.out.println("排序失败");
        }
    }
}
