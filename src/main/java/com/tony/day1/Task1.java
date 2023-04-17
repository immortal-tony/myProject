package com.tony.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName Task1
 * Description TODO
 * @Author hzf
 * @Date 2020/11/23 18:27
 */
public class Task1 {
    /**
     * 将链表，输出新链表表头
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator iterator = list.listIterator();
        List<String> newlist = new ArrayList<>();
        while (iterator.hasNext()){
            newlist.add(0,(String)iterator.next());
        }
        System.out.println(newlist.get(0).hashCode());
        Task1 task1 = new Task1();
        task1.task1(list);
    }

    /**
     * 反转链表
     * @param list
     */
    private void task1(List<String> list) {
        Collections.reverse(list);
        System.out.println(list);
    }
}
