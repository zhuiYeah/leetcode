package 双指针;

public class 重新排列元素 {
    public int[] shuffle(int[] nums, int n) {
        int ptr1 = 0, ptr2 = n;
        int[] res = new int[2 * n];
        for (int i = 0; i < 2 * n; i += 2) {
            res[i] = nums[ptr1];
            res[i + 1] = nums[ptr2];
            ptr1++;
            ptr2++;
        }
        return res;
    }
}
