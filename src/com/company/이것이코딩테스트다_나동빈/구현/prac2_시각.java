package com.company.이것이코딩테스트다_나동빈.구현;

import java.io.*;

public class prac2_시각 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int hour = 0; hour <= N; hour++) {
            for (int min = 0; min <= 59; min++) {
                for (int sec = 0; sec <= 59; sec++) {
                    if (hour % 10 == 3 || min / 10 == 3 || min % 10 == 3 || sec / 10 ==3 || sec % 10 ==3) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
