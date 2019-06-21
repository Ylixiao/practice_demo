package com.sys.tryxx.Offer;

import java.util.Stack;

//用两个栈实现队列的入队和出队
public class PopAndPush {

  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    if (stack1.isEmpty() && stack2.isEmpty()) {
      throw new RuntimeException("stack is null");
    }
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }
}