package com.company.프로그래머스.그리디;

import java.util.*;

public class 단속카메라 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    public static int solution(int[][] routes) {
        int answer = 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                System.out.print(routes[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }

}
