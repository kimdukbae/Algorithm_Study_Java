package com.company.이것이코딩테스트다_나동빈.그리디;

import java.util.*;
import java.io.*;

public class prac3_1이될때까지 {

    static int N, K;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while (true) {
            if (N == 1) {
                break;
            } else if (N % K == 0) {
                N /= K;
                answer++;
            } else {
                N -= 1;
                answer++;
            }
        }

        System.out.println(answer);
    }
}