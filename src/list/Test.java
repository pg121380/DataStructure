package list;

import java.util.LinkedList;

public class Test {
    @org.junit.Test
    public void testList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(123);
        linkedList.add(456);
        linkedList.add(789);
        linkedList.pop();
    }

    @org.junit.Test
    public void testMyList(){
        list.LinkedList<Integer> list = new list.LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.show();
        System.out.println("-------");
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
