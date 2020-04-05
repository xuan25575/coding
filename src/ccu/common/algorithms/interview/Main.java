package ccu.common.algorithms.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description 面试
 */
public class Main {

    public static void main(String[] args) throws IOException {

            Scanner in = new Scanner(System.in);
            while(in.hasNext()){
                int n = in.nextInt();
                BigDecimal[] nums = new BigDecimal[n];
                for(int i=0; i<n; i++){
                    nums[i] = in.nextBigDecimal();
                }
                BigDecimal res  = new BigDecimal(0);
                for (BigDecimal num : nums) {
                    res =num.add(res);
                }
                System.out.println(res);
            }

    }





}


