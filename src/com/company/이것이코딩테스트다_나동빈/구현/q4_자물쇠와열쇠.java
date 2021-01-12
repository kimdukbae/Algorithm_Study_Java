package com.company.이것이코딩테스트다_나동빈.구현;

//import java.util.*;
//import java.util.logging.Level;
//
//public class q4_자물쇠와열쇠 {
//
//    static int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
//    static int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//
//    public static void main(String[] args) {
//
//        System.out.println(solution(key, lock));
//
//    }
//
//    public static boolean solution(int[][] key, int[][] lock) {
//        int size = lock.length - 1;
//
//        for (int d = 0; d < 4; d++) {
//            int[][] rotateKey = rotate(d, key);
//            int[][] paddingKey = padding(rotateKey, size);
//
//            for (int I = 0; I < paddingKey.length - size; I++) {
//                for (int J = 0; J < paddingKey[0].length - size; J++) {
//                    boolean flag = true;
//
//                    for (int r = 0; r < lock.length; r++) {
//                        for (int c = 0; c < lock[0].length; c++) {
//                            if (lock[r][c] == paddingKey[I + r][J + c])
//                                flag = false;
//                        }
//                    }
//
//                    if (flag)
//                        return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public static int[][] rotate(int cnt, int[][] box) {
//        if (cnt == 0)
//            return box;
//
//        int[][] result = new int[box.length][box[0].length];
//        int[][] origin = copy(box);
//
//        for (int i = 0; i < cnt; i++) {
//            for (int r = 0; r < origin.length; r++) {
//                for (int c = 0; c < origin[0].length; c++) {
//                    result[c][origin.length - 1 - r] = origin[r][c];
//                }
//            }
//            origin = result;
//        }
//
//        return result;
//    }
//
//    public static int[][] copy(int[][] box) {
//        int[][] result = new int[box.length][box[0].length];
//
//        for (int i = 0; i < box.length; i++) {
//            for (int j = 0; j < box[i].length; j++) {
//                result[i][j] = box[i][j];
//            }
//        }
//
//        return result;
//    }
//
//    public static int[][] padding(int[][] arr, int size) {
//        int[][] result = new int[arr.length + size * 2][arr[0].length + size * 2];
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                result[i + size][j + size] = arr[i][j];
//            }
//        }
//
//        return result;
//    }
//}

import java.util.*;

public class q4_자물쇠와열쇠 {

    static int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
    static int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

    public static void main(String[] args) {
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int size = lock.length - 1;

        for(int d = 0 ; d < 4 ; ++d) {
            int[][] rotatedKey = rotate(d, key);
            int[][] paddedKey = padding(rotatedKey, size);

            for(int R = 0 ; R < paddedKey.length - size ; ++R) {
                for(int C = 0 ; C < paddedKey[0].length - size ; ++C) {
                    boolean flag = true;

                    for(int r = 0 ; r < lock.length ; ++r) {
                        for(int c = 0 ; c < lock[0].length ; ++c) {
                            if(lock[r][c] == paddedKey[R + r][C + c]) flag = false;
                        }
                    }

                    if(flag) return true;
                }
            }
        }

        return false;
    }

    private static int[][] padding(int[][] arr, int size) {
        int[][] result = new int[arr.length + size * 2][arr[0].length + size * 2];

        for(int r = 0 ; r < arr.length ; ++r) {
            for(int c = 0 ; c < arr[0].length ; ++c) {
                result[r + size][c + size] = arr[r][c];
            }
        }

        return result;
    }

    private static int[][] rotate(int cnt, int[][] arr){
        if(cnt == 0) return arr;

        int[][] result = null;
        int[][] origin = copy(arr);

        for(int i = 0 ; i < cnt ; ++i) {
            result = new int[arr.length][arr[0].length];

            for(int r = 0 ; r < origin.length ; ++r) {
                for(int c = 0 ; c < origin[0].length ; ++c) {
                    result[c][origin.length - 1 - r] = origin[r][c];
                }

            }
            origin = result;
        }

        return result;
    }

    private static int[][] copy(int[][] arr){
        int[][] result = new int[arr.length][arr[0].length];

        for(int r = 0 ; r < arr.length ; ++r) {
            for(int c = 0 ; c < arr[r].length ; ++c) {
                result[r][c] = arr[r][c];
            }
        }

        return result;
    }
}