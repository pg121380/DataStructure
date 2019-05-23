package tree;

public class Heap {
    private int[] data;
    private int size;

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Heap(int size){
        this.size = size;
        data = new int[size];
    }

    public Heap(int size,int[] data){
        this.data = data;
        this.size = data.length;
    }

    public boolean isFull(){
        return this.size == this.data.length;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     *通过下滤，将以start为根节点的子堆调整为最大堆/最小堆
     * @param start 从哪个节点开始调整
     */
    public void percDown(int start, int end){
        int parent,child;
        int temp;

        temp = this.data[start];
        for(parent = start;parent * 2 + 1 <= end;parent = child){
            child = parent * 2 + 1;
            if((child != end) && (this.data[child] < this.data[child + 1]))
                child++;
            if(temp >= this.data[child])
                break;
            else
                this.data[parent] = this.data[child];
        }
        this.data[parent] = temp;
    }

    public void buildHeap(){
        for(int i = this.data.length / 2 - 1;i >= 0;i--){
            percDown(i, this.data.length - 1);
        }
    }

    public boolean isMaxHeap(){
        for(int i = 0;(i * 2 + 1) <= this.data.length - 1 && (i * 2 + 2) <= this.data.length - 1;i++){
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
            if(this.data[i] < this.data[leftChild] || this.data[i] < this.data[rightChild])
                return false;
        }
        return true;
    }

    public boolean isMinHeap(){
        for(int i = 0;(i * 2 + 1) <= this.data.length - 1 && (i * 2 + 2) <= this.data.length - 1;i++){
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
            if(this.data[i] > this.data[leftChild] || this.data[i] > this.data[rightChild])
                return false;
        }
        return true;
    }
}
