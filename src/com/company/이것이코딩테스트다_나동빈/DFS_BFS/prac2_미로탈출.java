package com.company.이것이코딩테스트다_나동빈.DFS_BFS;

import java.util.*;
import java.io.*;

class XY {
    int r, c;

    public XY(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class prac2_미로탈출 {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static Queue<XY> q = new LinkedList<>();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] c = input.toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(c[j]));
            }
        }

        // 미로 탈출 전
        print(board);
        System.out.println("============");
        System.out.println(bfs(0, 0));

        // 미로 탈출 후
        System.out.println("============");
        print(board);

    }

    static int bfs(int x, int y) {
        q.offer(new XY(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            XY start = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = start.r + dir[i][0];
                int nc = start.c + dir[i][1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (board[nr][nc] == 1 && !visited[nr][nc]) {
                        q.offer(new XY(nr, nc));
                        visited[nr][nc] = true;
                        board[nr][nc] = board[start.r][start.c] + 1;
                    }
                }
            }
        }

        return board[N - 1][M - 1];
    }

    static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
