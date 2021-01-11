package com.company.이것이코딩테스트다_나동빈.구현;

import java.util.*;
import java.util.logging.Level;

class XY {
    int r, c;

    public XY(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class q4_자물쇠와열쇠 {

    static int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
    static int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    static Queue<XY> q_lock = new LinkedList<XY>();
    static Queue<XY> q_key = new LinkedList<XY>();

    public static void main(String[] args) {
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                if (lock[i][j] == 0) {
                    q_lock.offer(new XY(i, j));
                }
            }
        }

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == 1) {
                    q_key.offer(new XY(i, j));
                }
            }
        }

        for (int i = 0; i < q_key.size(); i++) {

            for (int j = 0; j < 4; i++) {

            }
        }


        return false;
    }

}
