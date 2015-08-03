package com.cwind.leetcode.stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/3
 * Email: billchen01@163.com
 * #232 - Easy
 */
public class QueueUsingStacks {

    Stack<Integer> stack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tempstack = new Stack<Integer>();
        while(!stack.isEmpty()){
            tempstack.push(stack.peek());
            stack.pop();
        }
        tempstack.push(x);
        stack.clear();
        while (!tempstack.isEmpty()){
            stack.push(tempstack.peek());
            tempstack.pop();
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        while (!queue.empty()){
            System.out.println(queue.peek());
            queue.pop();
        }
    }
}
