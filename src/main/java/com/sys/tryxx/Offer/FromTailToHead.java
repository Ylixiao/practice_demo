package com.sys.tryxx.Offer;

import java.util.ArrayList;
import java.util.Stack;

//输入一个链表 从尾到头输出listnode
public class FromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack stack = new Stack();
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;

        }
        while (!stack.empty()){
            list.add((Integer) stack.pop());
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode!=null){
          listNode = listNode.next;
            list.add(listNode.val);
        }
        return list;
    }

}

