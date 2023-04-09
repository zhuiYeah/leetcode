package 前缀和;

import java.util.HashMap;

/**
 * 数组长度为n
 * 找到字母与数字个数相等的 最长子数组
 * 如果有多个这样的数组
 * 返回下标最小的子数组
 * n <= 10^5
 */

/**找到和为0的最长子数组 并且时间复杂度必须为o(n)*/
//前缀和 + hashmap
public class 字母与数字 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = isNum(array[i]) ? 1 : -1;
        //找到和为0的最长子数组
        int[] s = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        int max = 0, start = 0; //结果子数组的下标为start,最大长度为max
        //现在找到s[r] - s[l] = 0 ，则可以说明数组[l,r-1]的和为0
        var map = new HashMap<Integer, Integer>(); //数字1 -> 该数字出现的最早下标
        for (int r = 0; r <= n; r++) {
            if (map.containsKey(s[r])) {
                int l = map.get(s[r]);
                if (r - l > max) {
                    start = l;
                    max = r - l;
                }
            } else {
                map.put(s[r], r);
            }
        }
        String[] res = new String[max];
        for (int i = start; i < max + start; i++) {
            res[i - start] = array[i];
        }
        return res;
    }

    private boolean isNum(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') continue;
            return false;
        }
        return true;
    }
}
