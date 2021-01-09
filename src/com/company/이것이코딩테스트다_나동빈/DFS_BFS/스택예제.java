package com.company.이것이코딩테스트다_나동빈.DFS_BFS;

import java.util.*;

public class 스택예제 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        // isEmpty() 와 empty()의 차이가 무엇일까...?

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
