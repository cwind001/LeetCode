package com.cwind.leetcode.stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/5
 * Email: billchen01@163.com
 * #20 - Easy
 */
public class ValidParenthese {
    public boolean isValid(String s) {
        if(s==null||s.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '{':
                case '[':
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if(stack.size()==0||stack.pop()!='{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.size()==0||stack.pop()!='['){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.size()==0||stack.pop()!='('){
                        return false;
                    }
                    break;
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        ValidParenthese tester = new ValidParenthese();
        System.out.println(tester.isValid("()"));
        System.out.println(tester.isValid("()[]{}"));
        System.out.println(tester.isValid("(]"));
        System.out.println(tester.isValid("([)]"));
        System.out.println(tester.isValid("]"));
    }
}
