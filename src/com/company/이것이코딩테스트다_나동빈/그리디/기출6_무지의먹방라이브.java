package com.company.이것이코딩테스트다_나동빈.그리디;

// https://github.com/ndb796/python-for-coding-test/blob/master/11/6.java
// https://jhhj424.tistory.com/34

// 복습 요망!!
import java.util.*;

class Food implements Comparable<Food> {

    // 음식의 시간 & 순서
    int time;
    int idx;

    public Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }

    // compareTo 메소드
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

public class 기출6_무지의먹방라이브 {

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        long food_sum = 0;  // 모든 음식 먹는데 걸리는 총 시간
        for (int i = 0; i < food_times.length; i++) {
            food_sum += food_times[i];
        }

        if (food_sum <= k) return -1;

        // (음식 시간, 순서) 쌍으로 우선순위 큐에 저장
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long total = 0;   // 먹기 위해 사용한 시간
        long previous = 0;  // 직전에 다 먹은 음식 시간
        long length = food_times.length;    // 남은 음식 개수

        while (total + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            total += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.idx, b.idx);
            }
        });

        return result.get((int) ((k - total) % length)).idx;
    }
}
