package ccu.swordoffer;
/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 【思路一】
 * 从二维数组的右上角往左下角开始比较。 如果右上角大于该数，去除该列，如果小于该数 去除该行。
 * 【思路二】
 *  从二维数组的左下角往右下角开始比较。
 */
public class Test03 {
    public static void main(String[] args) {
        int [] []  matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        boolean flag = findNumber(matrix,5);
        System.out.println("结果是："+flag);
        boolean flag2 = findNumber(null,3);
        System.out.println("结果是："+flag2);
    }

     public static boolean findNumber(int [][] matrix,int find){
        if(matrix == null ){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(rows <1 || columns <1){
            return false;
        }
        int row =0;
        int col = columns-1;
        //对 columns 和 row 判断
        while(row < rows  && col >= 0 ){
            if(matrix[row][col] == find){
                return true;
            }else if(matrix[row][col] > find){
                col--;
            }else{
                row++;
            }
        }
       return false;
     }
}
