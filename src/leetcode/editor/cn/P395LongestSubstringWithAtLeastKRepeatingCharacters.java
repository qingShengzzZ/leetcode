//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 329 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：至少有 K 个重复字符的最长子串
public class P395LongestSubstringWithAtLeastKRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P395LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        // TO TEST
        int aaabb = solution.longestSubstring("aaabb", 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        if (s.length()<k) return 0;
        if(s.length() < res){
            return res;
        }
        if(k ==1) return s.length();

            Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i),counter.getOrDefault(s.charAt(i),0)+1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                for (String t : s.split(String.valueOf(c))) {
                        res = Math.max(res, longestSubstring(t, k));

                }
                return res;
            }
        }
        return s.length();

        }


//        int ans = 0;
//        int n = s.length();
//        for (int t = 1; t <= getMaxUniqueLetters(s); t++) {
//            int l = 0, r = 0;
//            int[] cnt = new int[26];
//            // 滑动窗口内不同字符个数
//            int total = 0;
//            // 当前出现次数 小于k（且不为0）的字符数量
//            int less = 0;
//            while (r < n) {
//                int rChar = s.charAt(r) - 'a';
//                cnt[rChar]++;
//                if (cnt[rChar] == 1) {
//                    total++;
//                    less++;
//                }
//                if (cnt[rChar] == k) {
//                    less--;
//                }
//
//                while (total > t) {
//                    int lChar = s.charAt(l) - 'a';
//                    cnt[lChar]--;
//                    if (cnt[lChar] == k - 1) {
//                        less++;
//                    }
//                    if (cnt[lChar] == 0) {
//                        total--;
//                        less--;
//                    }
//                    l++;
//                }
//                if (less == 0) {
//                    ans = Math.max(ans, r - l + 1);
//                }
//                r++;
//            }
//        }
//        return ans;
//    }
//
//        private int getMaxUniqueLetters(String s) {
//            int mask = 0;
//            for (char ch : s.toCharArray()) {
//                mask |= 1 << (ch - 'a');
//            }
//            return Integer.bitCount(mask);
//        }

}
//leetcode submit region end(Prohibit modification and deletion)

}