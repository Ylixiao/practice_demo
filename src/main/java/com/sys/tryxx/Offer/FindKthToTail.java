package com.sys.tryxx.Offer;

/**
 * @program: tryxx
 * @description: 输出倒数第k个节点
 * @author: xiao
 * @create: 2018-11-09 16:06
 **/
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        int count = getListNode(head);
        if(k<0||head==null){
            return null;
        }
        for(int i= 0;i<count+2-k;i++){
            head = head.next;
        }
        return head;
    }

    private int getListNode(ListNode head) {
        int count = 0;
        while(head.next!=null){
            head = head.next;
            count++;
        }
        return count;
    }
}