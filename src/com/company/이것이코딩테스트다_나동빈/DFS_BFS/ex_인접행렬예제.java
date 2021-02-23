package com.company.이것이코딩테스트다_나동빈.DFS_BFS;

public class ex_인접행렬예제 {

    // 인접행렬
    public static final int INF = 999999999;
    public static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
    };

    public static void main(String[] args) {
        System.out.println("인접행렬");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
