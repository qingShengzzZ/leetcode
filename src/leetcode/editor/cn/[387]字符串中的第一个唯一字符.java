package leetcode.editor.cn;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 337 👎 0

class 字符串中的第一个唯一字符{
	public static void main(String[] args) {
		Solution solution = new 字符串中的第一个唯一字符().new Solution();
		int abca = solution.firstUniqChar("abcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(abca);

	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
		// 字符串长度不超过26，按照原先的方式遍历
		if (s.length() <= 26) {
			int[] chars = new int[26];
			for (char c : s.toCharArray()) {
				chars[c - 'a'] += 1;
			}
			for (int i = 0; i < s.length(); ++i) {
				if (chars[s.charAt(i) - 'a'] == 1) {
					return i;
				}
			}
		}
		//只遍历26个字母，使用indexOf函数检查字符索引
		int result = -1;
		for (char c = 'a'; c <= 'z'; ++c) {
			int pre = s.indexOf(c);
			// s包含该字符并且只出现一次
			if (pre != -1 && pre == s.lastIndexOf(c)) {
				// 取最前面的位置
				result = (result == -1 || result > pre) ? pre : result;
			}
		}
		return result;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}