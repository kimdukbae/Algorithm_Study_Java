package com.company.프로그래머스.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 조이스틱 {

    static String name;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();
        char[] names = null;
        names = name.toCharArray();

        // 조이스틱 좌우이동 -> 이 부분 복습필요!
        // https://parksuu.github.io/139-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-(java)/
        int minMove = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            if ((int) names[i] != 65) {
                int next = i + 1;
                while (next < name.length() && (int) names[next] == 65) {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }
        answer += minMove;

        // 조이스틱 상하이동
        // 상하이동은 쉽게 구현함. 하지만 좌우이동에서 막힘
        // 좌우이동의 최솟값을 구하는 것이 Greedy 여서 Greedy 문제로 분류되는듯...
        for (int i = 0; i < name.length(); i++) {
            int a_z = 0;
            int z_a = 0;
            for (int j = 65; j <= 90; j++) {
                if ((int) names[i] == j) {
                    break;
                }
                a_z++;
            }

            for (int j = 90; j >= 65; j--) {
                if ((int) names[i] == j) {
                    z_a++;
                    break;
                }
                z_a++;
            }
            answer += Math.min(a_z, z_a);
        }

        System.out.println(answer);

    }
}
