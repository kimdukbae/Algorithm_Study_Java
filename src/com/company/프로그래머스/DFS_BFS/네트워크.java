package com.company.프로그래머스.DFS_BFS;

import java.util.*;
import java.io.*;

public class 네트워크 {

    static int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    static int n = 3;

    public static void main(String[] args) {

        System.out.println(solution(n, computers));

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    dfs(computers, visited, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, boolean[] visited, int start) {
        visited[start] = true;
        // 내일 다시...!

    }

}

