package com.company.이것이코딩테스트다_나동빈.그리디;

import java.util.*;
import java.io.*;

// BOJ 1439
public class 기출3_문자열뒤집기 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char[] cArr = S.toCharArray();

        int zeroCnt = 0;    // 0 덩어리 개수
        int oneCnt = 0;     // 1 덩어리 개수

        for (int i = 0; i < cArr.length - 1; i++) {
            if (cArr[i] == '0') {
                if (cArr[i] != cArr[i + 1]) {
                    zeroCnt++;
                }
            } else if (cArr[i] == '1') {
                if (cArr[i] != cArr[i + 1]) {
                    oneCnt++;
                }
            }
        }

        if (cArr[cArr.length - 1] == '0') {
            zeroCnt++;
        } else if(cArr[cArr.length - 1] == '1') {
            oneCnt++;
        }

//        System.out.println(zeroCnt + " " + oneCnt);
        answer = Math.min(zeroCnt, oneCnt);
        System.out.println(answer);

    }
}