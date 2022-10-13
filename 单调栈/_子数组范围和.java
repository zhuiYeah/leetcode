package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;

//暴力 ,时间复杂度O（n2）
public class _子数组范围和 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += (long) max - (long) min;
            }
        }
        return res;
    }
}


////////////////////////////////////////////////////////////////////////
//单调栈

class crec {
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        //rightMax[i] : nums[i]右边第一个比nums[i]元素大的元素的下标
        int[] rightMin = new int[n];
        int[] leftMin = new int[n];
        Arrays.fill(rightMax, n);
        Arrays.fill(rightMin, n);
        Arrays.fill(leftMin, -1);
        Arrays.fill(leftMax, -1);
        //小顶栈找到下一个更大元素
        var stackMax = new ArrayDeque<Integer>();
        //大顶栈找到下一个更小元素
        var stackMin = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stackMax.isEmpty() && nums[i] > nums[stackMax.peek()]) {
                int index = stackMax.pop();
                rightMax[index] = i;
            }
            stackMax.push(i);
            while (!stackMin.isEmpty() && nums[i] < nums[stackMin.peek()]) {
                int index = stackMin.pop();
                rightMin[index] = i;
            }
            stackMin.push(i);
        }

        stackMax.clear();
        stackMin.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stackMax.isEmpty() && nums[i] >= nums[stackMax.peek()]) {
                int index = stackMax.pop();
                leftMax[index] = i;
            }
            stackMax.push(i);
            while (!stackMin.isEmpty() && nums[i] <= nums[stackMin.peek()]) {
                int index = stackMin.pop();
                leftMin[index] = i;
            }
            stackMin.push(i);
        }

        int[] maxCount = new int[n];
        int[] minCount = new int[n];
        for (int i = 0; i < n; i++) {
            maxCount[i] = (i - leftMax[i]) * (rightMax[i] - i);
            minCount[i] = (i - leftMin[i]) * (rightMin[i] - i);
        }
        //maxCount[i] : nums[i]作为最大值一共出现在maxCount[i]个区间中
        long res = 0;
        for (int i = 0; i < n; i++) res += (long) (maxCount[i] - minCount[i]) * nums[i];
        return res;
    }

    public static void main(String[] args) {
        subArrayRanges(new int[]{4,-2,-3,4,1});
    }
}