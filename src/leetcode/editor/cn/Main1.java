package leetcode.editor.cn;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[]  temp= new String[3]; //字符串数组做中间变量
        for(int i = 0; i< 3; i++) {
            temp[i] = scan.next();
        }
        char[][] p = new char[3][3];// temp字符串数组转为二维数组p[n][m];
        for (int a = 0; a < n; a++) {
            for(int i = 0; i<3; i++) {
                for(int j = 0; j< 3; j++) {
                    p[i][j] = temp[i].charAt(j);
                    System.out.println(p[i][j]);
                }
            }
        }
    }
}
