package leetcode.editor.cn;

import java.util.Collections;

public class QuanPaiLie {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        printArr(3);
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);


    }

    private static void printArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        perum(arr, 0, arr.length - 1);
    }

    public static void perum(int[] arr, int p, int q) {
        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        // 递归结束条件
        if (p == q) {
            //  一次递归结束。将整个数组打印出来
            printArray(arr);
//            System.out.println("p:"+p);
//            printArray( arr,q+1);
        }
        for (int i = p; i <= q; i++) {
            swap(arr, i, p);
//            System.out.println("i:"+i);
            // 把剩下的元素都做全排列。
            perum(arr, p + 1, q);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(arr, i, p);
        }
    }

    private static void swap(int[] arr, int i, int p) {
        int temp = arr[i];
        arr[i] = arr[p];
        arr[p] = temp;
    }

    private static void printArray(int[] arr) {
        for (int k : arr) {
            System.out.print(k);
        }
        System.out.println();
    }
}
