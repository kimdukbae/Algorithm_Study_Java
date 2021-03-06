package com.company.이것이코딩테스트다_나동빈.그리디;

import java.util.*;
import java.io.*;

public class 기출1_모험가길드 {

    static int N;
    static int[] explorer;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        explorer = new int[N];
        for (int i = 0; i < N; i++) {
            explorer[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(explorer);

        // 현재 그룹핑되는 그룹 인원 수
        int count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            if (count >= explorer[i]) {
                answer++;
                count = 0;
            }
        }

        System.out.println(answer);
    }
}