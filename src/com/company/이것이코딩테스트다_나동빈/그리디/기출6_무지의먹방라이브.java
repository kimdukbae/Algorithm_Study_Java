package com.company.이것이코딩테스트다_나동빈.그리디;

public class 기출6_무지의먹방라이브 {

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;
        long time = 0;
        int idx = 0;

        while (true) {
            if (idx == food_times.length) {
                idx = 0;
            }

            if (time == k) {
                answer = idx + 1;
                break;
            }

            // 먹방 시작
            time++;
            if (food_times[idx] <= 0) {
                idx += 1;
            }
            food_times[idx]--;
            idx++;
        }

        return answer;
    }
}
