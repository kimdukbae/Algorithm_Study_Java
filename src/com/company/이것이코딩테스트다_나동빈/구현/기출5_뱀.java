package com.company.이것이코딩테스트다_나동빈.구현;

// 안풀림 -> 탐색이 되다가 안된다...

//import java.util.*;
//import java.io.*;
//
//class Loc {
//    int r, c;
//
//    public Loc(int r, int c) {
//        this.r = r;
//        this.c = c;
//    }
//}
//
//public class q5_뱀 {
//
//    static Deque<Loc> q = new ArrayDeque<>();
//    static int N, K, L;
//    static int[][] board;
//    static int[] X;
//    static char[] C;
////    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//    static int direction = 1;
//    static int answer = 1;
//    static int idx = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        board = new int[N][N];
//        K = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < K; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int r = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            board[r - 1][c - 1] = 1;
//        }
//
//        L = Integer.parseInt(br.readLine());
//        X = new int[L];
//        C = new char[L];
//
//        for (int i = 0; i < L; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            X[i] = Integer.parseInt(st.nextToken());
//            String str = st.nextToken();
//            C[i] = str.charAt(0);
//        }
//
////        print(board);
//        q.offer(new Loc(0, 0));
//        move();
//        System.out.println();
//        print(board);
//        System.out.println(answer);
//    }
//
//    static void move() {
//        while (true) {
//            answer++;
//            Loc head = q.peekLast();
//            int nr = head.r + dir[direction][0];
//            int nc = head.c + dir[direction][1];
//
//            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
//                break;
//            }
//            if (q.size() >= 2) {
//                int startR = q.peekLast().r;
//                int startC = q.peekLast().c;
//                int endR = q.peekFirst().r;
//                int endC = q.peekFirst().c;
//                if (startR == endR && startC == endC) {
//                    break;
//                }
//            }
//
//            if (answer == X[idx]) {
//                System.out.println(X[idx] + " " + C[idx]);
//                if (C[idx] == 'L') {
//                    direction = (direction + 3) % 4;
//                    answer++;
//                    idx++;
//                } else if (C[idx] == 'D') {
//                    direction = (direction + 1) % 4;
//                    answer++;
//                    idx++;
//                }
//            }
//
//            if (board[nr][nc] == 1) {
//                q.offer(new Loc(nr, nc));
//                // 이 부분만 0으로 바꾸면됨
//                board[nr][nc] = 3;
//            } else if (board[nr][nc] == 0) {
//                q.pollFirst();
//                q.offer(new Loc(nr, nc));
//                board[nr][nc] = 9;
//            }
//
//        }
//    }
//
//    static void print(int[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//    }
//}

import java.util.*;

class Node {

    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return this.direction;
    }
}

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class 기출5_뱀 {

    public static int n, k, l;
    public static int[][] arr = new int[101][101]; // 맵 정보
    public static ArrayList<Node> info = new ArrayList<>(); // 방향 회전 정보

    // 처음에는 오른쪽을 보고 있으므로(동, 남, 서, 북)
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int turn(int direction, char c) {
        if (c == 'L') direction = (direction == 0) ? 3 : direction - 1;
        else direction = (direction + 1) % 4;
        return direction;
    }

    public static int simulate() {
        int x = 1, y = 1; // 뱀의 머리 위치
        arr[x][y] = 2; // 뱀이 존재하는 위치는 2로 표시
        int direction = 0; // 처음에는 동쪽을 보고 있음
        int time = 0; // 시작한 뒤에 지난 '초' 시간
        int index = 0; // 다음에 회전할 정보
        // 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
                // 사과가 없다면 이동 후에 꼬리 제거
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }
                // 사과가 있다면 이동 후에 꼬리 그대로 두기
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            }
            // 벽이나 뱀의 몸통과 부딪혔다면
            else {
                time += 1;
                break;
            }
            // 다음 위치로 머리를 이동
            x = nx;
            y = ny;
            time += 1;
            if (index < l && time == info.get(index).getTime()) { // 회전할 시간인 경우 회전
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        // 맵 정보(사과 있는 곳은 1로 표시)
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        // 방향 회전 정보 입력
        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }

        System.out.println(simulate());
    }

}
