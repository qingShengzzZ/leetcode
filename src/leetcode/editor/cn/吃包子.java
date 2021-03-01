package leetcode.editor.cn;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.util.Scanner;

public class 吃包子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()){
            String s = sc.nextLine();
            if(!" ".equals(s)){
                sb.append(s);
            }
        }
        System.out.println(sb.toString());


    }
}
