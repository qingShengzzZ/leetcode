package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoTest {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        long endTime = startTime +1000;
        long count = 0;

        while (true) {
            Math.sqrt(count);
            if (endTime < System.currentTimeMillis()){
                break;
            }
            ++count;
        }

        System.out.println(count);

    }
    static class A{
        public static void main(String[] args) {
            int[] s =new int[256];
            String a="aaaa";
            for (int i = 0; i < a.length(); i++) {
                s[a.charAt(i)]++;
            }
            s.toString();
         }
    }
    static class B{
        public static void main(String[] args) {
            List<Student> list = new ArrayList();
            list.add(new Student("0001", "学生甲"));
            list.add(new Student("0002", "学生乙"));
            list.add(new Student("0003", "学生丙"));
//转为map
            Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(e -> e.getId() + e.getName()));
            System.out.println(map);
        }
    }
}
