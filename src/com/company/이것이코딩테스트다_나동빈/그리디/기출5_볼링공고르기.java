package com.company.이것이코딩테스트다_나동빈.그리디;

import java.util.*;
import java.io.*;

public class 기출5_볼링공고르기 {

    static int N, M;
    static int[] ball;
    static int answer = 0;
    static ArrayList<Integer> combX = new ArrayList<>();
    static ArrayList<Integer> combY = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ball = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ball[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                combX.add(i);
                combY.add(j);
            }
        }

        // 해설에서는 다르게 풀었음.
        // https://github.com/ndb796/python-for-coding-test/blob/master/11/5.java
        for (int i = 0; i < combX.size(); i++) {
            if (ball[combX.get(i)] != ball[combY.get(i)])
                answer++;
        }

        System.out.println(answer);
    }
}
