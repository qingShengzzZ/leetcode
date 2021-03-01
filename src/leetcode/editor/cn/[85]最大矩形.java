package leetcode.editor.cn;

//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 688 👎 0

class 最大矩形{
	public static void main(String[] args) {
		Solution solution = new 最大矩形().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int col = matrix.length;
		int row = matrix[0].length;
		int[] heights = new int[row];
		int ans = 0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (matrix[i][j] == '1') {
					heights[j] += 1;
				} else {
					heights[j] = 0;
				}
			}
			ans = Math.max(ans, largestRectangleArea(heights));
		}
		return ans;

    }
	/**
	 * 84. 柱状图中最大的矩形
	 */
	public int largestRectangleArea(int[] heights) {
		int area = 0, len = heights.length;
		for (int i = 0; i < heights.length ; i++) {
			int w = 1, h = heights[i], j = i;
			while ( --j >= 0 && heights[j] >= h) { //找i的左边高度大于h的连续个数,注意边界
				w++;
			}
			j = i ;// 找i的右边高度大于h的连续个数
			while ( ++j < len && heights[j] >= h) {
				w++;
			}
			area = Math.max(area, w * heights[i]);
		}
		return area;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}