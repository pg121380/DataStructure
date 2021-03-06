package list;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    public LinkedList(){

    }

    private Node<T> head;

    private Node<T> tail;

    private int size = 0;

    public int size(){
        return size;
    }

    public boolean add(T value){
        addLast(value);
        return true;
    }

    public void addFirst(T value){
        if(head == null){
            Node<T> temp = new Node<>(value);
            head = temp;
            tail = head;
        } else {
            Node<T> temp = new Node<>(value, head);
            head = temp;
        }
        size++;
    }

    public void addLast(T value){

        if(head == null) {
            head = new Node<>(value, null);
            tail = head;
        } else if(tail != null){
            Node<T> insertNode = new Node<>(value);
            tail.setNext(insertNode);
            tail = insertNode;
        }
        this.size++;
    }

    public void show(){
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public void clear(){
        for(Node<T> temp = head; temp != null;){
            Node<T> next = temp.getNext();
            temp.setNext(null);
            temp.setData(null);
        }
        size = 0;
        head = tail = null;
    }

    public boolean contains(Object object){
        if(isEmpty()){
            return false;
        } else {
            Node<T> temp = head;
            while(temp != null){
                if(object.equals(temp.getData())){
                    return true;
                } else {
                    temp = temp.getNext();
                }
            }
            return false;
        }
    }

    public T element(){
        if(head == null){
            throw new NoSuchElementException("头结点不存在！");
        } else {
            return head.getData();
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T getFirst(){
        if(head != null){
            return head.getData();
        } else {
            throw new NoSuchElementException("头结点不存在！");
        }
    }

    public T getLast(){
        if(tail != null){
            return tail.getData();
        } else {
            throw new NoSuchElementException("尾节点不存在！");
        }
    }

    public T get(int index){
        if(!isLegalIndex(index)){
            throw new IndexOutOfBoundsException("请输入正确的索引！");
        } else {
            Node<T> temp = head;
            for(int i = 0;i < index;i++){
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }

    public T remove(int index){
        if(index == 0){
            Node<T> temp = head.getNext();
            head = temp;
        }
        if(!isLegalIndex(index)){
            throw new IndexOutOfBoundsException("请输入正确的索引！");
        } else {
            Node<T> temp = head;
            for(int i = 0;i < index - 1;i++){
                temp = temp.getNext();
            }
            Node<T> prev = temp;
            Node<T> delNode = temp.getNext();
            T elem = delNode.getData();
            prev.setNext(delNode.getNext());
            return elem;
        }
    }

    public void push(T value){
        addFirst(value);
    }

    public boolean isLegalIndex(int index){
        return (index >= 0 && index < size);
    }

    public T pop(){
        return remove(0);
    }
}
