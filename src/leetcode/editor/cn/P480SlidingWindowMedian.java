//中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 
//窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
// Related Topics Sliding Window 
// 👍 202 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//Java：滑动窗口中位数
public class P480SlidingWindowMedian{
    public static void main(String[] args) {
        Solution solution = new P480SlidingWindowMedian().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] rst = new double[nums.length-k+1];
        PriorityQueue<Integer> big = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        HashMap<Integer, Integer> debt = new HashMap<>();

        //balance记录了小值堆和大值堆之间数字的差值
        int i=0, j=k-1, index=0, balance=0;
        //init
        int[] tmpArray = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(tmpArray);
        int scope = (k&1)==1?k/2:k/2-1;
        for(int m=0; m<=scope; m++)
            small.offer(tmpArray[m]);
        for(int m=scope+1; m<k; m++)
            big.offer(tmpArray[m]);
        rst[index++] = insertRst(small, big, k);
        while(++j < nums.length){
            balance += deleteElment(debt, nums, i++, small, big);
            balance += insertElment(nums, j, small, big);
            makeBalance(debt, small, big, balance);
            rst[index++] = insertRst(small, big, k);
            balance = 0;
        }
        return rst;
    }

        private int deleteElment(HashMap<Integer, Integer> debt, int[] nums, int i, PriorityQueue<Integer> small, PriorityQueue<Integer> big)
        {
            int cur = nums[i];
            debt.put(cur, debt.getOrDefault(cur, 0)+1);
            return !small.isEmpty()&&nums[i]<=small.peek()?-1:1;
        }

        private int insertElment(int[] nums, int j, PriorityQueue<Integer> small, PriorityQueue<Integer> big)
        {
            if(!small.isEmpty() && nums[j]<=small.peek()){
                small.add(nums[j]);
                return 1;
            }
            big.add(nums[j]);
            return -1;
        }

        //balance记录了此时两个堆不平等的情况，需要将其平衡到初始水平，此时如果是正的，就从小堆中删除，加到大堆里，如果是负的，就反过来，平衡完之后，只需要对欠债元素进行删除就可。欠债元素必须先从small里进行删除，因为添加的时候也是优先添加到small，优先删除big中的元素极有可能导致big为空，从而导致添加中位数时出问题
        private void makeBalance(HashMap<Integer, Integer> debt, PriorityQueue<Integer> small, PriorityQueue<Integer> big, int balance)
        {
            assert balance==2||balance==-2||balance==0;
            if(balance>0)
                big.offer(small.poll());
            else if(balance<0)
                small.offer(big.poll());
            while(!small.isEmpty()&&debt.getOrDefault(small.peek(), 0) > 0){
                debt.put(small.peek(), debt.get(small.peek())-1);
                small.poll();
            }
            while(!big.isEmpty()&&debt.getOrDefault(big.peek(), 0) > 0){
                debt.put(big.peek(), debt.get(big.peek())-1);
                big.poll();
            }
        }

        private double insertRst(PriorityQueue<Integer> small, PriorityQueue<Integer> big, int k){
            return (k&1)==1?(double)small.peek():((double)small.peek()+(double)big.peek())/2;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}