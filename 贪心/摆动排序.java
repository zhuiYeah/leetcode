package 贪心;

import java.util.ArrayList;
import java.util.List;


public class 摆动排序 {
    int res = 2;

    public int wiggleMaxLength(int[] nums) {

        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums1.add(nums[i]);
            }
        }
        if (nums1.size() < 2) {
            return nums1.size();
        }
        for (int i = 1; i < nums1.size() - 1; i++) {
            if ((nums1.get(i) - nums1.get(i - 1)) * (nums1.get(i) - nums1.get(i + 1)) > 0) {
                res++;
            }
        }
        return res;
    }
}


