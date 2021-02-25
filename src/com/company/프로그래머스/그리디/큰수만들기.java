package com.company.프로그래머스.그리디;

public class 큰수만들기 {

    public static void main(String[] args) {

        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));

    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int answer_Length = number.length() - k;

        int start = 0;
        int end = number.length() - answer_Length;
        int idx = 0;

        while (answer_Length > 0) {
            int max = -1;
            for (int i = start; i <= end; i++) {
                int num = number.charAt(i) - '0';
                if (num > max) {
                    max = num;
                    idx = i;
                }
            }
            start = idx + 1;
            answer_Length--;
            end = number.length() - answer_Length;
            sb.append(max);
        }

        return sb.toString();
    }
}
