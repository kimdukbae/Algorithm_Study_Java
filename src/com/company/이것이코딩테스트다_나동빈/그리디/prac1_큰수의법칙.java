package com.company.이것이코딩테스트다_나동빈.그리디;

import java.util.*;
import java.io.*;

public class prac1_큰수의법칙 {

    static int N, M, K;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 1번째 풀이 (처음 내가 푼 방법)
        // 완전탐색(?)의 방법으로 풀었음.
//        int cnt = 0;
//        for (int i = 0; i < M; i++) {
//            if (cnt == K) {
//                answer += arr[N - 2];
//                cnt = 0;
//            } else {
//                answer += arr[N - 1];
//                cnt++;
//            }
//        }


        // 2번째 풀이
        // 가장 큰 수가 더해지는 횟수 & 그 다음으로 큰 수가 더해지는 횟수를 구함.
        // 1번째 풀이 보다 속도가 더 빠름!
        int first = arr[N - 1];
        int second = arr[N - 2];

        int cnt = (M / (K + 1)) * K;
        cnt += M % (K + 1);

        answer += cnt * first;
        answer += (M - cnt) * second;


        System.out.println(answer);
    }
}