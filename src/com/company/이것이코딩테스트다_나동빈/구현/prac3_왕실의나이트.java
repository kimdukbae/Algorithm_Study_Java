package com.company.이것이코딩테스트다_나동빈.구현;

import java.io.*;

public class prac3_왕실의나이트 {

    static int[][] dir = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;

        int row = input.charAt(1) - '1';
        int col = input.charAt(0) - 'a';

        for (int i = 0; i < 8; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            if (nr < 0 || nr > 7 || nc < 0 || nc > 7) continue;
            answer++;
        }

        System.out.println(answer);
    }

}
