package ccu.common.algorithms.interview;

import java.util.Arrays;
import java.util.Scanner;


public class Test51_1 {


    public static int live(int x,int f,int d, int p){
        int y = ((d - x*f )/ (x+p));
        return y + f;
    }

    public static void  live2(int t,int[][] arr){
        if(t < 0 || arr.length==0|| arr == null || arr[0].length ==0 ) return ;
        for (int i = 0; i < t; i++) {
            if(6*arr[i][0] == (arr[i][1]*1 + arr[i][2]*2 + arr[i][3]*3)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        int[][] arr = new int[n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                x = sc.nextInt();
                arr[i][j]=x;
            }
        }
        System.out.println(Arrays.toString(arr[0]));
    }

}
