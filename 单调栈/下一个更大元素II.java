package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        for (int num : nums) {
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = num;
            }
        }
        return res;
    }
}
