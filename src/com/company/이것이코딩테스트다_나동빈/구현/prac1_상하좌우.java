package com.company.이것이코딩테스트다_나동빈.구현;

import java.util.*;
import java.io.*;

public class prac1_상하좌우 {

    // 상 하 좌 우
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[] alpha = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int x = 0;
        int y = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (input[i].charAt(0) == alpha[j]) {
                    int nx = x + dir[j][0];
                    int ny = y + dir[j][1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    x = nx;
                    y = ny;
                }
            }
        }

        System.out.println((x + 1) + " " + (y + 1));
    }
}
