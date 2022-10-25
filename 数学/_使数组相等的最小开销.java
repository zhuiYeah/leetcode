package 数学;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
//来自316场周赛
//你可以对nums数组中的每一个元素进行任意次+1 -1操作，但是每次操作的开销为cost[i]；给出使得数组元素全部相同的最小开销。


//加权中位数 贪心
class dwqdew {
    int[] nums;
    int[] cost;

    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;
        int n = nums.length;
        mergeSort(0, n - 1);
        long total = 0;
        for (int c : cost) total += c; //不要用数据流求和，会出错
        long presum = 0;
        int target = -1;
        for (int i = 0; i < n; i++) {
            presum += cost[i];
            if (presum >= total/2) {
                target = nums[i];
                break;
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) cost[i]*Math.abs(nums[i] - target) ;
        }
        return res;
    }

    public void mergeSort(int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        int i = start, j = mid + 1;
        var tmpnums = new ArrayList<Integer>();
        var tmpcost = new ArrayList<Integer>();
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmpnums.add(nums[i]);
                tmpcost.add(cost[i]);
                i++;
            } else {
                tmpnums.add(nums[j]);
                tmpcost.add(cost[j]);
                j++;
            }
        }
        while (i <= mid) {
            tmpnums.add(nums[i]);
            tmpcost.add(cost[i]);
            i++;
        }
        while (j <= end) {
            tmpnums.add(nums[j]);
            tmpcost.add(cost[j]);
            j++;
        }
        for (i = start; i <= end; i++) {
            nums[i] = tmpnums.get(i - start);
            cost[i] = tmpcost.get(i - start);
        }
    }
}


//数学 + 枚举 + 前缀和 ，利用数学公式使得在O(1)时间内完成每一次枚举
class dwsxwqdewdwe {
    long res = Long.MAX_VALUE;
    int[] nums;
    int[] cost;
    int n;
    long[] prefixNumsACost;
    long[] prefixCost;

    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;
        n = cost.length;
        prefixCost = new long[n];
        prefixNumsACost = new long[n];
        mergeSort(0, n - 1);
        prefixNumsACost[0] = (long) nums[0] * cost[0];
        prefixCost[0] = cost[0];
        for (int i = 1; i < n; i++) {
            prefixNumsACost[i] = (long) nums[i] * cost[i] + prefixNumsACost[i - 1];
            prefixCost[i] = cost[i] + prefixCost[i - 1];
        }
        count(nums[0], 0);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                count(nums[i], i);
            }
        }
        return res;
    }

    public void count(int x, int k) {
        long xx = x * (2 * prefixCost[k] - prefixCost[n - 1]) - 2 * prefixNumsACost[k] + prefixNumsACost[n - 1];
        res = Math.min(xx, res);
    }

    public void mergeSort(int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        int i = start, j = mid + 1;
        var tmpnums = new ArrayList<Integer>();
        var tmpcost = new ArrayList<Integer>();
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmpnums.add(nums[i]);
                tmpcost.add(cost[i]);
                i++;
            } else {
                tmpnums.add(nums[j]);
                tmpcost.add(cost[j]);
                j++;
            }
        }
        while (i <= mid) {
            tmpnums.add(nums[i]);
            tmpcost.add(cost[i]);
            i++;
        }
        while (j <= end) {
            tmpnums.add(nums[j]);
            tmpcost.add(cost[j]);
            j++;
        }
        for (i = start; i <= end; i++) {
            nums[i] = tmpnums.get(i - start);
            cost[i] = tmpcost.get(i - start);
        }
    }

}

//枚举所有可能，超时 41/44
class wedwwe {
    long res = Long.MAX_VALUE;
    int[] nums;
    int[] cost;

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        this.nums = nums;
        this.cost = cost;
//        var sort = new int[n];
//        System.arraycopy(nums, 0, sort, 0, nums.length);
//        Arrays.sort(sort);
//        for (int i = 0; i < sort.length; i++) {
//            help(sort[i]);
//        }
        var set = new HashSet<Integer>();
        for (int num : nums) set.add(num);
        for (int num : set) help(num);
        return res;
    }

    //这里是在O(n)时间完成枚举 ， 下面的方法利用 前缀和+数学推导 使得可以在O(1)时间完成枚举
    public void help(int target) {
        long maybe = 0;
        for (int i = 0; i < nums.length; i++) {
            maybe += (long) Math.abs(nums[i] - target) * cost[i];
        }
        res = Math.min(res, maybe);
    }
}


//大佬的答案
public class _使数组相等的最小开销 {
    public long minCost(int[] nums, int[] cost) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (o, p) -> nums[o] - nums[p]);
        long min = 0, curr = 0, sum = 0;
        for (int i = 0; i < nums.length; sum += cost[i++]) {
            min = curr += (long) (nums[i] - nums[index[0]]) * cost[i];
        }
        for (int i = 1; i < index.length; i++) {
            min = Math.min(min, curr -= (sum -= 2 * cost[index[i - 1]]) * (nums[index[i]] - nums[index[i - 1]]));
        }
        return min;
    }
}
