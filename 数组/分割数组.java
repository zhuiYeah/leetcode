package 数组;

public class 分割数组 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        var rightMin = new int[n];
        rightMin[n - 1] = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(nums[i + 1], min);
            rightMin[i] = min;
        }
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max,nums[i]);
            if (max <= rightMin[i]) return i+1;
        }
        return 0;
    }
}
