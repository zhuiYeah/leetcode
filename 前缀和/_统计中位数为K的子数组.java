package 前缀和;

import java.util.HashMap;
import java.util.Map;

// 42 / 45
public class _统计中位数为K的子数组 {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kidx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kidx = i;
                break;
            }
        }
        int[] left = new int[kidx + 1];
        int[] right = new int[n - kidx];
        right[0] = 0;
        for (int i = kidx + 1; i < n; i++) {
            if (nums[i] > k) right[i - kidx] = right[i - kidx - 1] + 1;
            else right[i - kidx] = right[i - kidx - 1];
        }
        left[kidx] = 0;
        for (int i = kidx - 1; i >= 0; i--) {
            if (nums[i] > k) left[i] = left[i + 1] + 1;
            else left[i] = left[i + 1];
        }
        int res = 0;
        for (int i = left.length - 1; i >= 0; i--) {
            for (int j = 0; j < right.length; j++) {
                //除了k以外的 区间长度
                int len = kidx - i + j;
                int shouldContain = 0;
                //该区间内比k大的数字个数
                int numHigherK = left[i] + right[j];
                if (len % 2 == 0) shouldContain = len / 2;
                else shouldContain = len / 2 + 1;
                if (numHigherK == shouldContain) res++;
                if (shouldContain > numHigherK) break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        new _统计中位数为K的子数组().countSubarrays(new int[]{2, 3, 1}, 3);
    }
}

//中位数k ： 大于k的全部为1，小于k的全部为-1，k计0
//找到和为1或0且包含k的全部子数组
class dededw3 {
    public int countSubarrays(int[] nums, int k) {
        int pos = 0, n = nums.length;
        while (nums[pos] != k) pos++;
        // 和 -> 该 和 的子数组出现个数 (以pos位置作为开头的子数组)
        var cnt = new HashMap<Integer, Integer>();
        cnt.put(0, 1);
        for (int i = pos + 1, c = 0; i < n; i++) {
            c += nums[i] > k ? 1 : -1;
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        //单纯以pos位置开头的和为 0 1 的子数组
        ans += cnt.get(0) + cnt.getOrDefault(1, 0);
        for (int i = pos - 1, c = 0; i >= 0; i--) {
            c += nums[i] > k ? 1 : -1;
            //以nums[i]位置开头的包含 和为 0 1的子数组
            ans += cnt.getOrDefault(-c, 0) + cnt.getOrDefault(-c + 1, 0);
        }
        return ans;
    }
}


/**
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * 注意：
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素
 */


class de3wcd {
    public int countSubarrays(int[] nums, int k) {
        int pos = 0, n = nums.length;
        while (nums[pos] != k) pos++;
        Map<Integer, Integer> map = new HashMap<>();//记录左半部分和出现的次数
        int sum = 0;
        map.put(0, 1);//和0已经出现一次了
        //和为0或1且 包含 k 的 子数组的数量
        for (int i = pos - 1; i >= 0; i--) {
            sum += nums[i] > k ? 1 : -1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int ans = 0;
        sum = 0;
        ans += map.get(0) + map.getOrDefault(1, 0);
        for (int i = pos + 1; i < n; i++) {
            sum += nums[i] > k ? 1 : -1;
            ans += map.getOrDefault(-sum, 0) + map.getOrDefault(-sum + 1, 0);
        }
        return ans;
    }
}


