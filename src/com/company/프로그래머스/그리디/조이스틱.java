package com.company.프로그래머스.그리디;

public class 조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }

    public static int solution(String name) {
        int answer = 0;
        char[] names = name.toCharArray();
        int minMove = name.length() - 1;

        // 복습 요망!!
        // 조이스틱 좌우이동 최솟값 구하기
        // https://parksuu.github.io/139-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-(java)/
        for (int i = 0; i < name.length(); i++) {
            if ((int) names[i] != 65) {
                int next = i + 1;
                while (next < name.length() && (int) names[next] == 65) {
                    next++;
                }
                int move = 2 * i + name.length() - next;    // ??
                minMove = Math.min(move, minMove);
            }
        }
        answer += minMove;

        // 조이스틱 상하이동 최솟값 구하기
        for (int i = 0; i < name.length(); i++) {
            int front_a = Math.abs((int) names[i] - 65);
            int end_z = Math.abs((int) names[i] - 90) + 1;
            answer += Math.min(front_a, end_z);
        }

        return answer;
    }
}
