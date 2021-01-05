package com.company.프로그래머스.완전탐색;

import java.util.*;

public class 모의고사 {

    static int[] answers = {1, 3, 2, 4, 2};
    static int[][] person = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    static int[] result = new int[3];
    static ArrayList<Integer> result_idx = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < person.length; i++) {
            int score = 0;
            for (int j = 0; j < answers.length; j++) {
                // person의 찍는방법이 반복되어야함.
                // 처음에는 i가 0, 1, 2 일 때를 전부 다 구현
                // -> 아래와 같이 구현하면 훨씬 좋다!!
                if (person[i][j % person[i].length] == answers[j])
                    score++;
            }
            result[i] = score;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) {
                result_idx.add(i + 1);
            }
        }

        print();
    }

    static void print() {
        for (int k : result_idx) {
            System.out.print(k + " ");
        }
    }
}
