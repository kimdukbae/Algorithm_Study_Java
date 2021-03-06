package com.company.프로그래머스.그리디;

import java.util.*;

public class 단속카메라 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int min = Integer.MIN_VALUE;
        for(int[] route : routes) {
            if (min < route[0]) {
                min = route[1];
                answer++;
            }
        }

        return answer;
    }

}
