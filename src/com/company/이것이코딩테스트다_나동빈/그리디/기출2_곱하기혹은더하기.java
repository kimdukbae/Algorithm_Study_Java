package com.company.이것이코딩테스트다_나동빈.그리디;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.*;
import java.io.*;

public class 기출2_곱하기혹은더하기 {

    static String S;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        answer = S.charAt(0) - '0';

        for (int i = 1; i < S.length(); i++) {
            int compare = S.charAt(i) - '0';

            // answer == 0 일 때 '+' 연산을 수행하게 함 -> charAt(0)이 1일 때 'x' 연산을 수행하게 되서 오류 발생함!
            // charAt(0)이 0, 1 일 때 '+' 수행해야 한다.
            if (compare <= 1 || answer <= 1) {
                answer += compare;
            } else {
                answer *= compare;
            }
        }

        System.out.println(answer);
    }
}
