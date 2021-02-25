package com.company.프로그래머스.그리디;

import java.util.*;

public class 구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
        System.out.println(solution(new int[]{50, 30, 20, 70, 10}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        // https://velog.io/@kimdukbae/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8-Java
        // right(최댓값 index)만 for문 돌 때마다 하나씩 감소하게 됨. (left는 증감 X)
        // 2개 더한값이 limit 초과하면 left는 고정! (어차피 right는 감소됨.)
        // 2개 더한값이 limit 이하이면 left+1 수행! (어차피 right는 감소됨.)
        for (int i = right; i >= left; i--) {
            // 구명보트 혼자 타는 경우
            if (people[i] + people[left] > limit) {
                answer++;
            } 
            // 무게제한 맞아서 구명보트 딱 2명이서 같이 타는 경우
            else {
                answer++;
                left++;
            }
        }

        return answer;
    }
}
