package com.company.프로그래머스.정렬;

import java.util.Arrays;

public class K번째수 {

    static int[] arr = {1, 5, 2, 6, 3, 7, 4};
    static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    static int[] answer;

    public static void main(String[] args) {
        answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int first = commands[i][0];
            int second = commands[i][1];
            int[] temp = new int[second - first + 1];
            int idx = 0;
            for (int j = first - 1; j < second; j++) {
                temp[idx] = arr[j];
                idx++;
            }
//            Arrays.sort(temp);

            // 퀵소트를 직접 구현하는 것보다 라이브러리가 더 빠르다...??
            // BUT 퀵소트로 구현해서 맞춘사람도 있음 --> 구현한 퀵소트 알고리즘 성능이 안좋은듯 하다...
            quickSort(temp, 0, temp.length - 1);

            answer[i] = temp[commands[i][2] - 1];
        }
        print();
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int low = left;
        int high = right;

        while (low < high) {
            while (arr[pivot] > arr[low]) low++;
            while (arr[pivot] < arr[high]) high--;
            if (low < high) swap(arr, low, high);
        }
        swap(arr, pivot, high);
        return high;
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void print() {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
