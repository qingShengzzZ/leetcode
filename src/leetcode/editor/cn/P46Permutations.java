//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1147 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Java：全排列
public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int n = nums.length;
        backTrack(n,res,0,list);
        return res;

    }

    private void backTrack(int n,List<List<Integer>> res, int k, List<Integer> list) {
        if (k == n){
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = k; i < n; i++) {
            Collections.swap(list,k,i);
            backTrack(n,res,k+1,list);
            Collections.swap(list,k,i);
        }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}