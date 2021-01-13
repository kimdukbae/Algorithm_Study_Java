package com.company.프로그래머스.DFS_BFS;

import java.util.*;
import java.io.*;

public class 타겟넘버 {

    static int[] numbers = {1, 1, 1, 1, 1};
    static int k = 3;
    static int answer = 0;

    public static void main(String[] args) {

        System.out.println(solution(numbers, k));

    }

    public static int solution(int[] numbers, int k) {
        dfs(numbers, k, 0, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int k, int idx, int sum) {
        if (idx == numbers.length && sum == k) {
            answer++;
//            System.out.println(idx + " " + sum);
            return;
        }

        if (idx == numbers.length) {
            return;
        }

        dfs(numbers, k, idx + 1, sum + numbers[idx]);
        dfs(numbers, k, idx + 1, sum - numbers[idx]);
    }
}
