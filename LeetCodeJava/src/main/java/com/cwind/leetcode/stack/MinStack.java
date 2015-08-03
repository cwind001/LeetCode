package com.cwind.leetcode.stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/3
 * Email: billchen01@163.com
 * #155 - Easy
 */
public class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(x<min){
            min = x;
        }
    }

    public void pop() {
        if(stack.peek()>min){
            stack.pop();
        }else {
            min = Integer.MAX_VALUE;
            Stack<Integer> tmpStack = new Stack<Integer>();
            stack.pop();
            while(!stack.empty()){
                if(stack.peek()<min){
                    min = stack.peek();
                }
                tmpStack.push(stack.pop());
            }

            while (!tmpStack.empty()){
                stack.push(tmpStack.pop());
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(4);
        minStack.push(2);

        System.out.println("Min element in stack: " + minStack.getMin());
        while (!minStack.empty()){
            System.out.println(minStack.top());
            minStack.pop();
        }
    }
}
