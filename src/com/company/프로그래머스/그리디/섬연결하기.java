package com.company.프로그래머스.그리디;

import java.util.*;

// 정점 클래스
class Edge implements Comparable<Edge> {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class 섬연결하기 {

    static int[] parent;
    static PriorityQueue<Edge> pq;

    // main
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    // solution
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        pq = new PriorityQueue<Edge>();

        // 정점들의 부모 설정
        for (int i = 0; i < n; i++)
            parent[i] = i;

        // 비용 적은 순서부터 우선순위 큐에 삽입
        for (int i = 0; i < costs.length; i++) {
            pq.offer(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            // 정점의 부모가 같으면 건너뜀 (사이클이 형성된 것으로 판단)
            if (find(edge.start) == find(edge.end)) continue;
            else {
                union(edge.start, edge.end);
                answer += edge.cost;
            }
        }

        return answer;
    }

    // find --> 정점의 부모를 찾아줌.
    public static int find(int p) {
        if (parent[p] == p) return p;
        return parent[p] = find(parent[p]);
    }

    // union --> 정점의 부모를 변경시킴으로써 서로 연결되었다는 것을 표시해줌.
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }
}