//package com.company.이것이코딩테스트다_나동빈.DFS_BFS;
//
//import jdk.internal.util.xml.impl.Input;
//
//import java.util.*;
//import java.io.*;
//
//public class prac1_음료수얼려먹기 {
//
//    static int[][] map;
//    static int N, M;
//    static boolean[][] visited;
//    static int answer = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new int[N][M];
//        visited = new boolean[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
////        print(map);
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (dfs(i, j)) {
//                    answer++;
//                }
//            }
//        }
//        System.out.println(answer);
//
//    }
//
//    static boolean dfs(int r, int c) {
//        if (r < 0 || r >= N || c < 0 || c >= M) {
//            return false;
//        }
//
//        if (map[r][c] == 0 && !visited[r][c]) {
//            visited[r][c] = true;
//
//            dfs(r - 1, c);
//            dfs(r + 1, c);
//            dfs(r, c - 1);
//            dfs(r, c + 1);
//
//            return true;
//        }
//        return false;
//    }
//
//    static void print(int[][] map) {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//    }
//
//}
