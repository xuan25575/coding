package ccu.swordoffer;


/**
 * 对公司所有员工的年龄进行排序，公司总共有几万名员工，要求时间复杂度为O（n）。
 * 常数辅助空间
 */
public class Test8_1 {

    public static void sortAges(int[] ages){
        if(ages == null){
            return;
        }
        int length = ages.length;
        int oldAge = 99;
        int[] timesOfAge = new int[100];
        for (int i = 0; i < length; i++) {
            if(ages[i] < 0 || ages[i] > oldAge){
                throw new RuntimeException("不合法的年龄");
            }
            timesOfAge[ages[i]] ++;
        }
        int index = 0;
        for (int i = 0; i <= oldAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr  = {3,42,1,5,7,27,4,12,3,46,56,3,27};
        sortAges(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
//        次数为0不进入
//        for (int i = 0; i < 0 ; i++) {
//            System.out.println("enter ?? ");
//        }
    }

}
