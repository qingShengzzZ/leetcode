//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 动态规划 
// 👍 63 👎 0


package leetcode.editor.cn;

//Java：最大的以 1 为边界的正方形
public class P1139Largest1BorderedSquare {
    public static void main(String[] args) {
        Solution solution = new P1139Largest1BorderedSquare().new Solution();
        // TO TEST
//        int i = solution.largest1BorderedSquare(new int[][]{{1, 1, 0, 0}});
//        System.out.println(i);
        String s = new String("abcdefABCDEF");
        for (int i = 0; i <s.length(); i++) {
            int c =s.charAt(i);
            System.out.println(c);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][][] dp = new int[m + 1][n + 1][2];
            int res = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i - 1][j - 1] == 1) {
                        dp[i][j][0] = dp[i - 1][j][0] + 1;
                        dp[i][j][1] = dp[i][j - 1][1] + 1;
//                int side = Math.min(dp[i][j][0],dp[i][j][1]);
//                    for (int k = 0; k < Math.min(dp[i][j][0], dp[i][j][1]); k++) {

                    }
                }
            }
            for (int k = Math.min(m, n); k >= 1; k--) {
                for (int i = m; i - k + 1 > 0; i--) {
                    for (int j = n; j - k + 1 > 0; j--) {
                        if (dp[i][j][0] >= k && dp[i][j][1] >= k && dp[i - k + 1][j][1] >= k && dp[i][j - k + 1][0] >= k)
                            return k * k;
                    }
                }
            }
            return 0;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}