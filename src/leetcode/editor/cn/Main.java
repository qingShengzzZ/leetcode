package leetcode.editor.cn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//生成Scanner对象
        String s = sc.nextLine();
        String r = pigLatin(s);
        System.out.println(r);


        sc.close();
    }

    public static String pigLatin(String S) {
        String[] strs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        String vowel = "aeiouAEIOU";
        for (int i = 0; i < strs.length; i++) {
            sb.append(vowel.indexOf(strs[i].charAt(0)) == -1 ? strs[i].substring(1) + strs[i].charAt(0) + "ay"
                    : strs[i] + "ay");
            sb.append(' ');
        }
        return sb.toString().trim();
    }

}