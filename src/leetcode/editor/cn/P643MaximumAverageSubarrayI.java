//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 146 👎 0


package leetcode.editor.cn;
//Java：子数组最大平均数 I
public class P643MaximumAverageSubarrayI{
    public static void main(String[] args) {
        Solution solution = new P643MaximumAverageSubarrayI().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int res = sum;
        for (int i = k; i <nums.length ; i++) {
            sum = sum + nums[i]- nums[i-k];
            res = Math.max(res,sum);
        }
        return (double) res/k;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}