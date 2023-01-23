package 蒸蒸简单;

import java.util.HashSet;

public class 最小公共值 {
    public int getCommon(int[] nums1, int[] nums2) {
        var setNum1 = new HashSet<Integer>();
        for (int i : nums1) setNum1.add(i);
        var common = new HashSet<Integer>();
        for (int i : nums2) {
            if (setNum1.contains(i)) common.add(i);
        }
        int MOD = (int) (Math.pow(10, 9) + 100);
        int min = MOD;
        for (int i : common) min = Math.min(min, i);
        if (min == MOD) return -1;
        return min;
    }
}
