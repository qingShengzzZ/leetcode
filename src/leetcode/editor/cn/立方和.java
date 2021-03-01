package leetcode.editor.cn;

import java.util.Arrays;

public class 立方和 {
    public static void main(String[] args) {
        int sum = 0;
        int[] ints = new int[2020];
        for (int i = 0; i < 2020; i++) {
            ints[i]=i;
        }
        int sum1 = Arrays.stream(ints).filter(i -> (String.valueOf(i).contains("2") || String.valueOf(i).contains("0") || String.valueOf(i).contains("1") || String.valueOf(i).contains("9")))
                .map(i -> i * i * i).sum();
        System.out.println(ints[2019]);
        System.out.println(sum1);
        for (int i = 1; i <= 2019; i++) {
            int a = i;
            while (a != 0) {
                if (a % 10 == 2 || a % 10 == 0 || a % 10 == 1 || a % 10 == 9) {
                    sum += i * i * i;
                    break;
                }
                a /= 10;
            }
        }
        System.out.println("------------------");
        System.out.println(sum);

    }
}
