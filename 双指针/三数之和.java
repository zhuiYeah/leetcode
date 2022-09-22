package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            //加了一行从 58直接到99
            if (a > 0) break;

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                if (sum == 0) {
                    var x = new ArrayList<Integer>();
                    x.add(a);
                    x.add(nums[left]);
                    x.add(nums[right]);
                    res.add(x);
                    right--;
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
