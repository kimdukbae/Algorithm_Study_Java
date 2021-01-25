package com.company.프로그래머스.DFS_BFS;

public class 단어변환 {

    static int answer = 0;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, 0, visited);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt, boolean[] visited) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (check(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean check(String begin, String words) {
        int cnt = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == words.charAt(i))
                cnt++;
        }

        if (cnt == begin.length() - 1)
            return true;

        return false;
    }

}