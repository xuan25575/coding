package ccu.swordoffer;

/**
 * 题目：求1 + 2 + ···+ n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A ? B : C）
 */
public class Test46 {

    private static int sum = 0;
    private static int cnt = 0;
    public static class Temp{
        public Temp(){
            cnt++;
            sum += cnt;
        }
        public static int getSum(){
            return sum;
        }
    }

    public static void main(String[] args) {
//        int n = 3;
//        Temp[] temps =  new Temp[n];
//        for (int i = 0; i < temps.length; i++) {
//            temps[i] = new Temp();
//        }
//        System.out.println(temps[n-1].getSum());
        System.out.println(solution(10));
    }

    public static int solution(int n ){
        int res = n;
        boolean flag = n > 0 && (res += solution(n-1))>0;
        return res;
    }
}
