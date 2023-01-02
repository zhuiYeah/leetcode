package 二分查找;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 每次操作将一个可以将一个袋子里面的球分成两份装进两个袋子（袋子数量无限），最多进行maxOperations次,
 * 问你操作结束后，所有袋子中球最多的袋子的球 最少是多少
 */

/**最小化 ？ 最大代价 ？  最小化最大代价？  关键词察觉  直接二分答案**/


//堆 暴力模拟 超时 48/58
public class 二分答案_袋子里最少数目的球 {
    int K;
    int[] nums;
    PriorityQueue<Integer> PQ;

    public int minimumSize(int[] nums, int maxOperations) {
        K = maxOperations;
        this.nums = nums;
        PQ = new PriorityQueue<Integer>((a, b) -> b - a);
        int left = 1, right = (int) 1e9;
        var res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canIFuckYou(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    //我能不能以cost的代价操到你
    private boolean canIFuckYou(int cost) {
        int maxOperations = K;
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        //pq.addAll(PQ);
        for (int num : nums) {
            if (num > cost) pq.add(num);
        }
        while (maxOperations > 0) {
            maxOperations--;
            if (pq.size() == 0) return true;
            if (cost >= pq.peek()) return true;
            int num = pq.poll();
            if (num <= 2 * cost) continue;
            pq.add(num - cost);
        }
        return pq.size() == 0 || pq.peek() <= cost;
    }
}


//排序  +  模拟优化  + 二分答案
class dedede {
    int K;
    int[] nums;

    public int minimumSize(int[] nums, int maxOperations) {
        K = maxOperations;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length/2; i++) {
            var tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
        this.nums = nums;
        int left = 1, right = (int) 1e9;
        var res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canIFuckYou(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    //我能不能以cost的代价操到你
    private boolean canIFuckYou(int cost) {
        int operations = K;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            //后面的（包括我）你都可以不消费任何代价直接操
            if (cost >= nums[i]) return true;
            //你操我nums[i]需要的付出的次数
            int cnt = (int) Math.ceil((double) nums[i] / cost) - 1;
            if (operations < cnt) return false;
            operations -= cnt;
        }
        return true;
    }
}


class dedefde {
    public static void main(String[] args) {
        var nums = new int[]{431, 922, 158, 60, 192, 14, 788, 146, 788, 775, 772, 792, 68, 143, 376, 375, 877, 516, 595, 82, 56, 704, 160, 403, 713, 504, 67, 332, 26};
        var x = new dedede().minimumSize(nums, 80);
    }
}

