package com.company.이것이코딩테스트다_나동빈.그리디;

import java.util.*;
import java.io.*;

public class prac2_숫자카드게임 {

    static int N, M;
    static int[][] card;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        card = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(card[i]);
            if (answer < card[i][0]) {
                answer = card[i][0];
            }
        }

        System.out.println(answer);

    }
}