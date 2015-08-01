package com.cwind.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/1
 * Email: billchen01@163.com
 * #225 - Easy
 */
public class StackUsingQueues {

    Queue<Integer> queue = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        for(int i=0; i<queue.size()-1; i++){
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues sq = new StackUsingQueues();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);

        while(!sq.empty()){
            System.out.println(sq.top());
            sq.pop();
        }
    }
}
