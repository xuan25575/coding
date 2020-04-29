package ccu.swordoffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 回溯法；
 */
public class Test67 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[] flag = new boolean[rows*cols];//可以用一个二维数组
        return  movingCountCore(0,0,rows,cols,flag,threshold);
    }

    private int movingCountCore(int i ,int j,int rows,int cols,boolean[] flag,int threshold){
        int index = i*cols+j;//遍历 从第一列开始
        if(i<0 || j <0 || i>= rows || j >= cols || getSumNum(i) +getSumNum(j) > threshold || flag[index]) {
            return 0;
        }
        flag[index] =true;
        return 1+ movingCountCore(i+1,j,rows,cols,flag,threshold) +
                  movingCountCore(i-1,j,rows,cols,flag,threshold) +
                movingCountCore(i,j+1,rows,cols,flag,threshold) +
              movingCountCore(i,j-1,rows,cols,flag,threshold);
    }

    private int getSumNum(int i){
        int  sum = 0;
        while(i>0){
            sum += i%10; // 先求最低位
            i = i/10;
        }
        return sum;
    }
}
