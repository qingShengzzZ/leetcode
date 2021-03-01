//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 并查集 图 二分查找 
// 👍 129 👎 0


package leetcode.editor.cn;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//Java：最小体力消耗路径
public class P1631PathWithMinimumEffort{
    public static void main(String[] args) {
        Solution solution = new P1631PathWithMinimumEffort().new Solution();
        // TO TEST
        int[] int1 = {1, 2, 2};
        int[] int2 = {3, 8, 2};
        int[] int3 = {5, 3, 5};
        int[][] ints = {int1, int2, int3};
        int i = solution.minimumEffortPath(ints);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;
            //Kruskal构造连边
            List<int[]> edges = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int id = i * cols + j;
                    if (i < rows - 1) {
                        edges.add(new int[]{id, id + cols, Math.abs(heights[i][j] - heights[i + 1][j])});
                    }
                    if (j < cols - 1) {
                        edges.add(new int[]{id, id + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                    }
                }
            }
            //根据结点之间的权值进行排序
            Collections.sort(edges, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            int ans = 0;
            //从小到大连通结点
            UnionFind uf = new UnionFind(rows * cols);
            for (int i = 0; i < edges.size(); i++) {
                int[] temp = edges.get(i);
                int x = temp[0];
                int y = temp[1];
                int dp = temp[2];
                if (uf.find(x) != uf.find(y)) {
                    uf.union(x, y);
                    ans = dp;
                }
                //左上角结点和右下角结点连通
                if (uf.find(0) == uf.find(rows * cols - 1)) {
                    break;
                }
            }
            return ans;
        }

        //并查集
        class UnionFind {
            int[] f;

            public UnionFind(int n) {
                f = new int[n];
                for (int i = 0; i < n; i++) {
                    f[i] = i;
                }
            }

            //查
            public int find(int x) {
                if (f[x] != x) {
                    f[x] = find(f[x]);
                }
                return f[x];
            }

            //并
            public void union(int x, int y) {
                if (find(x) != find(y)) {
                    f[find(x)] = find(y);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}