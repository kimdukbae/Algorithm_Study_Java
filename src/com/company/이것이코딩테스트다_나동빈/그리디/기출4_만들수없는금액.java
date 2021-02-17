package com.company.이것이코딩테스트다_나동빈.그리디;

import java.util.*;
import java.io.*;

// 복습 요망!!
public class 기출4_만들수없는금액 {

    static int N;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coin = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin);
        int target = 1;
        // 아래의 로직이 신기함...
        for (int i = 0; i < N; i++) {
            if (target < coin[i])
                break;

            target += coin[i];
        }

        System.out.println(target);
    }
}