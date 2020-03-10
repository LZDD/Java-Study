package com.lzdd.adal.algorithm.leetcode;


import java.util.Stack;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/10 9:59 下午
 **/
public class PrintLinkedList {


    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        PrintLinkedList pll = new PrintLinkedList();
        //pll.method1(root);

        //pll.method2(root);

        pll.method3(root);
    }

    // 方法1 递归调用
    public void method1(ListNode listNode){
        if (listNode != null){
            if (listNode.getNext() != null){
                method1(listNode.getNext());
            }
            System.out.println(listNode.getNum());
        }
    }

    // 方法2 头插法，构建新链表
    public void method2(ListNode listNode){
        ListNode head = new ListNode(null);

        while (listNode != null){
            ListNode memo = listNode.getNext();
            listNode.setNext(head.getNext());
            head.setNext(listNode);
            listNode = memo;
        }

        while ((head = head.getNext()) != null){
            System.out.println(head.getNum());
        }
    }

    // 方法3 栈
    public void method3(ListNode listNode){
        Stack<ListNode> stack = new Stack();
        while (listNode != null){
            stack.push(listNode);
            listNode = listNode.getNext();
        }
        while (!stack.empty()){
            System.out.println(stack.pop().getNum());
        }
    }

}

class ListNode{
    private Integer num;
    private ListNode next;

    public ListNode(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}