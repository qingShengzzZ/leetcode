//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 273 👎 0


package leetcode.editor.cn;
//Java：替换后的最长重复字符
public class P424LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        Solution solution = new P424LongestRepeatingCharacterReplacement().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int l=0,r=0,recMax =0;
        for (r = 0; r < chars.length; r++) {
            int index = chars[r]-'A';
            map[index]++;
            recMax=Math.max(recMax,map[index]);
            if(r-l+1>recMax+k){
                map[chars[l]-'A']--;
                l++;
            }
        }
        return chars.length-l;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}