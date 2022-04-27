package interview;

import java.util.ArrayList;

/**
 * @auther guolei
 * @create 1-1-1 1
 */
public class Test2 {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int n = Integer.MAX_VALUE;
//        int[] arr = new int[2];
//        arr[0] = 1;
//        arr[1] = 2;
//        for(int i=2;i<n;i++){
//            arr[i%2] = arr[(i-1)%2] + arr[(i-2)%2];
//        }
//        System.out.println("1:"+arr[(n - 1) % 2]);

        long x = 1;
        long y = 1;
        long z = 1;
        for(int i = 2;i < n;i++){
            z = x + y;
            x = y;
            y = z;
        }
        System.out.println("2:"+z);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
//        int res = jump(n);
//        System.out.println(res);
    }
    public static int jump(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        //递归
        return jump(n - 1) + jump(n - 2);
    }
}
