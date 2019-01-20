package ccu.common.algorithms.practice.class_3;

/**
 *  给定一个整型矩阵matrix，请按照转圈的方式打印它。
 *  例如：
     1 2 3 4
     5 6 7 8
     9 10 11 12
     13 14 15 16
     打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，
     10
 *
 *   额外空间复杂度为O(1)。
 *
 *   思路： 一种宏观调度的思想，取一个左上一个点和右下一个点
 *    在矩阵中左上角的坐标（tR,tC）和右下脚的坐标（dR,dC）就可以表示 一个子矩阵，可以打印一圈
 *    然后宏观缩小左上角的坐标（tR++,tC++）和右下脚的坐标（dR--,dC--）
 */
public class PrintMatrixSpiralOrder {


    /**
     * 打印
     * @param matrix
     */
    public static void  spiralOrderPrint(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length-1; // y 坐标
        int dC = matrix[0].length-1; // x 坐标
        while(tR <= dR && tC <= dC){
            printEdge(matrix,tR++,tC++,dR--,dC--); //表示缩小一圈
        }

    }

    /**
     * 打印一圈  matrix[tR][tC] 左上坐标点  matrix[dR][dC]右下坐标点  核心方法
     * @param matrix
     * @param startY  坐标
     * @param startX  坐标
     * @param endY  坐标
     * @param endX  坐标
     */
    public static void printEdge(int[][] matrix,int startY,int startX, int endY,int endX){
        if(startX == endX){ //一列
            for (int i = startY; i <= endY; i++) {
                System.out.print(matrix[i][startX]+" " );
            }
        }else if(startY == endY){ //一行
            for (int i = startX; i <= endX; i++) {
                System.out.print(matrix[startY][i]+" ");
            }
        }else{  // 多行多列
            int curY = startY;
            int curX = startX;
            while(curX != endX){  // 往右走， 行号不变为第一行  列号++
                System.out.print(matrix[startY][curX]+" ");
                curX++;
            }
            while(curY != endY){ // 往下走  列号不变为最后一列 行号++
                System.out.print(matrix[curY][endX]+" ");
                curY++;
            }
            while(curX != startX){// 往左走  行号不变 为最后一行， 列号——
                System.out.print(matrix[endY][curX]+" ");
                curX--;
            }
            while(curY != startY){ // 往上走 ， 列号不变为开始列 行号——
                System.out.print(matrix[curY][startX]+" ");
                curY--;
            }
        }
    }


    public static void main(String[] args) {
//        int[][] matrix = { { 1, 2, 3, 4 },
//                           { 5, 6, 7, 8 },
//                           { 9, 10, 11, 12 },
//                           { 13, 14, 15, 16 },
//                           { 17, 18, 19, 20 } };
        int[][] matrix = { { 1, 2, 3, 4 ,5},
        { 6, 7, 8, 9 ,10},
        { 11, 12, 13, 14 ,15},
        {  16, 17, 18, 19 ,20},
        { 21, 22, 23, 24 ,25}};
        spiralOrderPrint(matrix);
        System.out.println();

        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        spiralOrderPrint(numbers5);
    }




















}
