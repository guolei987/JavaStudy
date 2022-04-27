package interview;

import java.util.Arrays;

/**
 * @auther guolei
 * @create 1-1-1 1
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,3,2,1,5,6,3,9,7,1};
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j=0;
            while(arr[j] <= arr[i] && j < i){
                j++; //找到第一个大于a[i]的元素
            }
            for(int k=i-1;k>=j;k--){
                arr[k+1] = arr[k];
            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
        String s = "1,#,#,2,#,2";
        String[] split = s.split(",");
        System.out.println(Arrays.toString(split));
    }
}
