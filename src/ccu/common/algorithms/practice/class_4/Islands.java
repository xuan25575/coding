package ccu.common.algorithms.practice.class_4;

/**
     哈希——并查集结构——岛问题
     一个矩阵中只有0和1两种值， 每个位置都可以和自己的上、 下、 左、 右四个位置相连,
     连成一片的1，如果周围都是0，那么这一片1，构成一个岛。 求一个矩阵中有多少个岛？
     举例：
     0 0 1 0 1 0
     1 1 1 0 1 0
     1 0 0 1 0 0
     0 0 0 0 0 0
 *    这个矩阵中有三个岛
 *    当矩阵数量较少时，解法（使用递归）
 *     两个函数
 *    1.遍历函数：遍历矩阵，遇到为1的点，就调用感染函数
 *    2.感染函数 ：使用递归的方法，将连成一片的1变成2
 *
 */
public class Islands {


    /**
     *  计数函数
     * @param m
     * @return
     */
    public static int countIslands(int[][] m){
        if(m == null || m.length  == 0 || m[0].length ==0){
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M ; j++) {
                if(m[i][j] == 1){
                    count++;
                    infect(m,i,j,N,M);
                }
            }
        }
        return count;
    }


    /**
     * 感染函数 使用递归的方法，将连成一片的1变成2
     * @param m 矩阵
     * @param i 横坐标
     * @param j 纵坐标
     * @param N  横长
     * @param M  纵长
     */
    public static void  infect(int[][] m,int i,int j,int N,int M){
        if(i<0 || i >= N || j<0 || j >= M || m[i][j] != 1 ){
            return;
        }
        m[i][j] = 10; //注意 只是一个标识。标识这个位置走过了。
        infect(m,i-1,j,N,M);
        infect(m,i+1,j,N,M);
        infect(m,i,j-1,N,M);
        infect(m,i,j+1,N,M);
    }


    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

//        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
//                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
//                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
//                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
//                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
//                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
//        System.out.println(countIslands(m2));

//        int[][] m = {
//                {0, 0, 1, 0, 1, 0},
//                {1, 1, 1, 0, 1, 0},
//                {1 ,0 ,0, 1, 0 ,0},
//                {0 ,0 ,0 ,0 ,0, 0}
//        };
//        System.out.println(countIslands(m));

    }














}
