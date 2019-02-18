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
}