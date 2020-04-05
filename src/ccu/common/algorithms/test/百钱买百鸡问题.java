package ccu.common.algorithms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author huang_2
 * @Date 2020/3/29 1:29 下午
 * @Description 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 *
 * 输出参数（指针指向的内存区域保证有效）：
 *     list  鸡翁、鸡母、鸡雏组合的列表
 *
 *  鸡翁、鸡母、鸡雏分别为x, y, z 三个变量。
 *  x+y+z=100
 *  5x+3y+z/3=100
 */
public class 百钱买百鸡问题 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ="";
        while((line=br.readLine())!=null){
            int i,j;
            for(i=0;i<=20;++i) {
                for(j=0;j<=100-i;++j) {
                    int k = 100-i-j;
                    if((k%3 ==0) && (5*i+3*j+k/3==100))
                        System.out.println(i+" "+j+" "+k);
                }
            }
        }
    }
}
