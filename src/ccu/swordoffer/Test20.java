package ccu.swordoffer;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
 *
 * 可参考 calss_3 包下 PrintMatrixSpiralOrder 类
 */
public class Test20 {

    public static void printMatrix(int[][] mtx){
        if(mtx == null || mtx.length == 0){
            return;
        }
        int rows = mtx.length;
        int columns = mtx[0].length;
        int start = 0;
        while(columns > 2*start && rows > 2*start){
            printMatrixInCircle(mtx,start,columns,rows);
            start ++;
        }

    }


    public static  void printMatrixInCircle(int[][] arr,int start,int columns,int rows){
        int endX =  columns-1-start;
        int endY = rows-1-start;

        // 打印一行
        for (int i = start; i <= endX ; i++) {
            System.out.print(arr[start][i]+" ");
        }

        // 2. 从上到下打印一列
        //  矩阵的高度至少是2，才会输出右边的一列 而且第一个不用输出
        //  即 要终止行号 > 起始行号
        if(start < endY){
            for (int i = start+1; i <= endY; i++) {
                System.out.print(arr[i][endX]+" ");
            }
        }
        //3. 从右往左打印一行
        //  矩阵的高度>=2 && 矩阵的宽度至少也得是2，才会输出下面的那一行
        if(start < endX && start < endY){
            for (int i = endX-1; i >= start ; i--) {
                System.out.print(arr[endY][i]+" ");
            }
        }
        //4. 从下到上打印一行
        //  矩阵的高度至少是3 && 宽度>=2
        if(start < endX && start < endY-1){
            for (int i = endY-1; i >= start+1 ; i--) {
                System.out.print(arr[i][start]+" ");
            }
        }
    }

    public static void main(String[] args) {
            int[][] numbers = {
                    {1, 2, 3, 4, 5},
                    {16, 17, 18, 19, 6},
                    {15, 24, 25, 20, 7},
                    {14, 23, 22, 21, 8},
                    {13, 12, 11, 10, 9},
            };
            printMatrix(numbers);
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
            printMatrix(numbers5);
    }
}
