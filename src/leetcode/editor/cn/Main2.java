package leetcode.editor.cn;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        //题目说明每行输入字符数目不超过100000个，故加5防止超出
        int maxn = 100000+5;
        //last输入字符串的最后一个字符后面的位置
        //cur表示光标的当前位置
        //next[]在这里相当于链表的指针域
        int last;
        int cur;
        int[] next;
//        next = new int [];
        //s[]数组相当于链表的数据域
//        char s[] =new char[];
        //s[0]相当于链表的头结点，不存放数据
//        s[0] = 0;
        //字符串str起缓冲作用，Java语言无法直接从键盘输入char型数据
        String str;
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext()){
            str = sc.next();
            char s[] =new char[20];
            next = new int [20];
            s[0] = 0;
            //将输入的字符串赋值给s[]数组，注意从s[1]开始赋值，因为s[0]为头结点，不存放数据
            for(int i = 0; i < str.length(); i ++){
                s[i+1] = str.charAt(i);
            }
            //s[]数组非0元素的长度为1+str.length()
            int n = str.length()+1;
            //第一次输入时，光标的当前位置与最后位置都在0处
            last = cur = 0;
            //next[0]相当于头结点的指针，在赋值之前指向null，此处的0就相当于null
            next[0] = 0;
            for(int i = 1; i <= n; i ++){
                char ch = s[i];
                //当输入'['时，光标定位至起始位置
                if(ch == '[') cur = 0;
                    //当输入']'时，光标定位至末尾位置
                else if(ch == ']') cur = last;
                    //输入正常文本时，光标顺次后移
                else{
                    next[i] = next[cur];
                    next[cur] = i;
                    if(cur == last) last = i;
                    cur = i;
                }
            }
            for(int i = next[0]; i != 0; i = next[i]){
                System.out.print(s[i]);
            }
            System.out.println();
        }
        sc.close();
    }

}