//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 757 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：N 皇后
public class P51NQueens{
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        dfs(n,0, chars,res);
        return res;
    }

        private void dfs(int n,int k, char[][] chars, List<List<String>> res) {
            if(k == n){
                List<String> list = new ArrayList<>();
                for (char[] aChar : chars) {
                    list.add(new String((aChar)));
                }
                res.add(list);
                return;
            }
            for (int col = 0; col < n; col++) {
                if (!isValid(chars, k, col))
                    continue;
                chars[k][col] = 'Q';
                dfs(n,k + 1, chars, res);
                //恢复现场
                chars[k][col] = '.';
            }
        }

        private boolean isValid(char[][] chars, int k, int col) {
            int n = chars.length;
            // 检查列是否有皇后互相冲突
            for (int i = 0; i < n; i++) {
                if (chars[i][col] == 'Q')
                    return false;
            }
            // 检查右上方是否有皇后互相冲突
            for (int i = k - 1, j = col + 1;
                 i >= 0 && j < n; i--, j++) {
                if (chars[i][j] == 'Q')
                    return false;
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = k - 1, j = col - 1;
                 i >= 0 && j >= 0; i--, j--) {
                if (chars[i][j] == 'Q')
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}