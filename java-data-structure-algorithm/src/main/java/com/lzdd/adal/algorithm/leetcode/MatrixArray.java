package com.lzdd.adal.algorithm.leetcode;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 9:33 下午
 **/
public class MatrixArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(MatrixArray.find(5,matrix));
        System.out.println(MatrixArray.find(20,matrix));
    }

    public static boolean find(int target,int[][] matrix){
        if (matrix == null || matrix.length < 1 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int r = 0,c = col -1;
        while (r < row && c >= 0){
            if (matrix[r][c] == target){
                return true;
            }

            if (target > matrix[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }
}
