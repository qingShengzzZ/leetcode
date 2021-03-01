//package leetcode.editor.cn;
//
////给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
////
//// 例如：
////给定二叉树 [3,9,20,null,null,15,7],
////
////
////    3
////   / \
////  9  20
////    /  \
////   15   7
////
////
//// 返回锯齿形层序遍历如下：
////
////
////[
////  [3],
////  [20,9],
////  [15,7]
////]
////
//// Related Topics 栈 树 广度优先搜索
//// 👍 345 👎 0
//
//import javax.swing.tree.TreeNode;
//import java.util.ArrayList;
//import java.util.List;
//
//class 二叉树的锯齿形层序遍历{
//	public static void main(String[] args) {
//		Solution solution = new 二叉树的锯齿形层序遍历().new Solution();
//
//	}
////leetcode submit region begin(Prohibit modification and deletion)
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//		List<List<Integer>> res = new ArrayList<>();
//		traversal(root, res, 0);
//		return res;
//	}
//
//	private void traversal(TreeNode root, List<List<Integer>> res, int level) {
////		if (root == null) {
////			return;
////		}
////
////		if (res.size() == level) {
////			res.add(new ArrayList<Integer>());
////		}
////
////		if ((level & 1) == 1){
////			res.get(level).add(0, root.val);
////		} else {
////			res.get(level).add(root.val);
////		}
////
////		traversal(root.left, res, level + 1);
////		traversal(root.right, res, level + 1);
////	}
//
//
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}