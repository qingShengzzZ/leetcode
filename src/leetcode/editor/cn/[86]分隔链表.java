package leetcode.editor.cn;

//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 336 👎 0

class 分隔链表{
	public static void main(String[] args) {
		Solution solution = new 分隔链表().new Solution();
		ListNode a = new ListNode(1);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(2);
		a.next.next.next.next = new ListNode(5);
		a.next.next.next.next.next = new ListNode(2);
		solution.partition(a,3);

	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
		ListNode l = new ListNode(0);
		ListNode r = new ListNode(0);
		ListNode pl = l;
		ListNode pr = r;
		while (head!=null){
			ListNode node = new ListNode(head.val);
			if (head.val<x){
				pl.next = node;
				pl = pl.next;
			}else {
				pr.next = node;
				pr = pr.next;
			}
			head = head.next;
		}
		pl.next = r.next;
		return l.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
 class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}