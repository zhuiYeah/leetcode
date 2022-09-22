package 双指针;

//经典双指针
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
