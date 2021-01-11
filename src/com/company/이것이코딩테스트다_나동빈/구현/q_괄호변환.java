package com.company.이것이코딩테스트다_나동빈.구현;


import java.util.Stack;

public class q_괄호변환 {

    static Stack<Character> s = new Stack<>();
    static char[] c;

    public static void main(String[] args) {
        solution("(()())())");
    }

    public static void solution(String p) {
        c = new char[p.length()];
        c = p.toCharArray();

        s.push(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (s.isEmpty()) break;

            if (s.peek() == '(') {
                if (c[i] == ')') s.pop();
                else s.push(c[i]);
            } else if (s.peek() == ')') {
                if (c[i] == '(') s.pop();
                else s.push(c[i]);
            }
        }

        if (!s.isEmpty()) {
            System.out.println("X");
        } else {
            System.out.println("균형잡힌 문자열");
        }
    }

}
