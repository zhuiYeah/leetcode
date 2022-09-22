package 动态规划;

public class 接雨水 {
    public int trap(int[] height) {
        int n = height.length;
        var dpLeft = new int[n];
        var dpRight = new int[n];
        dpLeft[0] = 0;
        dpRight[n - 1] = 0;
        int max = height[0];
        for (int i = 1; i < n; i++) {
            dpLeft[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dpRight[i] = max;
            max = Math.max(max, height[i]);
        }
        int area = 0;
        for (int i = 1; i < n - 1; i++) {
            int high = Math.min(dpLeft[i], dpRight[i]);
            if (high > height[i]) {
                area += high - height[i];
            }
        }
        return area;
    }
}
