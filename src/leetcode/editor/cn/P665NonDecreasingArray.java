//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
//
// 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 说明： 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 
// 👍 470 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：非递减数列
public class P665NonDecreasingArray{
    public static void main(String[] args) {
        Solution solution = new P665NonDecreasingArray().new Solution();
        // TO TEST
        solution.checkPossibility(new int[]{2,3,2,2,3,2,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i-1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i-2>=0 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            }else {
                nums[i-1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}