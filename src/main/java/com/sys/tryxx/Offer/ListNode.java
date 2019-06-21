package com.sys.tryxx.Offer;

public class ListNode {
       int val;
        ListNode next = null;
               ListNode(int val) {
            this.val = val;
        }
    }
    class Solutiont{
        public ListNode FindKthToTail(ListNode head,int k) {
            int count = getListNode(head);
            if(count+1>=k){
                for(int i= 0;i<count+1-k;i++){
                    head = head.next;
                }
            }else {
                return null;
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
