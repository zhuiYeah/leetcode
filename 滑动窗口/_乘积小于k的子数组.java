package 滑动窗口;

//9。22  自己写的暴力 滑动窗口写不出来
//暴力
//超越5%
public class _乘积小于k的子数组 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        if (k <= 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum < k) res++;
            for (int j = i + 1; j < nums.length; j++) {
                sum *= nums[j];
                if (sum < k) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////
//滑动窗口
//完全写错了，滑动窗口太难写了
//class huadong {
//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int left = 0, right = 0;
//        int ans = 0;
//        int sum = nums[0];
//        while (right < nums.length) {
//            //left right的区间能构成一个合法子数组
//            while (sum < k) {
//                ans += right - left + 1;
//                right++;
//                if (right == nums.length) break;
//                sum *= nums[right];
//            }
//            while (sum >= k && left < nums.length) {
//                sum /= nums[left];
//                left++;
//            }
//        }
//        return ans;
//    }
//}

////////////////////////////////////////////////////////////////////////////////////////////////
class huadong2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) return 0;
        int left = 0;
        int sum = 1;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (sum >= k) {
                sum /= nums[left++];
            }
            //现在left right构成一个sum小于k的区间
            res += right - left + 1;
        }
        return res;
    }
}


class cecede {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) return 0;
        int left = 0;
        int sum = 1;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (sum >= k) {
                sum /= nums[left];
                left++;
            }
            //为什么加上 right - left + 1是核心中的核心
            res += right - left + 1;
        }
        return res;
    }
}
