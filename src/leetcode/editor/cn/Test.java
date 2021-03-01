package leetcode.editor.cn;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
//        testA();
//        testB();
//        testD(40);
        testE("eca");

    }
    public static void testB() {
        int cnt = 0;
        Calendar c_begin = Calendar.getInstance();
        Calendar c_end = Calendar.getInstance();
        c_begin.set(2000, 1, 1);
        c_end.set(2020, 10, 1);

        c_end.add(Calendar.DAY_OF_YEAR, 1);
        while (c_begin.before(c_end)) {
            if (c_begin.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || c_begin.get(Calendar.DAY_OF_MONTH) == 1) {
                cnt++;
            }
            cnt++;
            c_begin.add(Calendar.DAY_OF_YEAR, 1);
        }
        System.out.println(cnt);
    }



    public static void testA() {
        int x=0;
        for (int i = 1; i < 78121; i++) {
            if(78120%i == 0){
                x+=1;
            }
        }
        System.out.println(x);
    }
    public static void testD(int n) {
        int arr[][] = new int[n][n];
        int cnt =1;
        for (int i = 0; i < n; i++) {
            for (int x = i,j = 0; x>=0&&j<=i; j++,x--) {
               arr[x][j] = cnt++;
            }
            }
        System.out.println(arr[19][19]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        }
    public static void testE(String e) {
        char[] arr = e.toCharArray();
        int res = 0;
        for (char c : arr) {
            int t = c - 'a';
            res = res | (1 << t);
        }
        int t =res;

        while (t > 0) {
            t = (t-1) & res;
//            Integer.toBinaryString()
//            String s = Integer.toBinaryString(t);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if ((t&(1<<i)) == (1<<i)){
                    int i2 = i  + 'a';
                    char i1 = (char) i2;
                    sb.append(i1);
                }
            }

//            char[] chars = s.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[i]=='1'){
//                    int i2 = i  + 'a';
//                    char i1 = (char) i2;
//                    sb.append(i1);
//                }
//            }
            System.out.println(sb);

        }


    }



    }


