package ccu.common.algorithms.practice.class_3;

/**
 *   给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如：
 *           1 2 3 4
 *           5 6 7 8
 *           9 10 11 12
 *   “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 *    思路：定义两个点a，b。刚开始时a点和b点都在（0,0）位置，然后a点往右走，
 *    b点往下走，当a点碰到最右边时，a点往下走，当b点碰到最下边时，b点往右走。每走一次，就打印a点，
 *    b点对角线上的数字。然后在定义一个bool类型的变量来判断是从右上到左下打印还是从左下到右上打印。
 *
 *
 *    同时往前走  两点对应一条斜线打印出来，通过Boolean 变量可控制打印方向。从而实现之字型打印
 *
 */
public class ZigzagPrintMatrix {


    /**
     * 打印之字型
     * @param matrix
     */
    public static void printZigzagMatrix(int[][] matrix){
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        int endR = matrix.length-1;
        int endC = matrix[0].length-1;
        boolean fromUp = false;

        while(row1 <= endR+1){
            printLevel(matrix,row1,col1,row2,col2,fromUp);  //开始时：matrix[row1][col1]这个点往下走   matrix[row2][col2]这个点右走
            //这里的顺序很重要。w为啥？？ 这是坐标变化
            row1 = col1 == endC ? row1+1: row1;
            col1 = col1 == endC ? col1 : col1+1;
            col2 = row2 == endR ? col2+1: col2;
            row2 = row2 == endR ? row2 :row2+1;
            fromUp = !fromUp;
        }
        System.out.println();

    }



    /**
     *  打印一斜行数据， 桶过Boolean 变量控制 打印方向，
     * @param matrix 矩阵
     * @param row1  横坐标
     * @param col1  纵坐标
     * @param row2  横坐标
     * @param col2  纵坐标
     * @param fromUp 控制打印方向
     */
    public static void printLevel(int[][] matrix, int row1,int col1,int row2,int col2,boolean fromUp){
        if(fromUp){  // 从上往下
            while(row1 != row2+1){  //row1 <= row2
                System.out.print(matrix[row1++][col1--]+" ");
            }
        }else{    // 从下往上
            while(row2 != row1-1){ // row2 >= row1
                System.out.print(matrix[row2--][col2++]+" ");
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },
                           { 5, 6, 7, 8 },
                           { 9, 10, 11, 12 } };
        printZigzagMatrix(matrix);

    }



//    public String say(){
//        if(true){
//            return "hello ";
//        }else{
//            return "world";
//        }
//    }

//    public String say1(){
//        if(true){
//            return "hello ";
//        }else if(true){
//            return "world";
//        }else{
//            return "wuw";
//        }
//    }
}
