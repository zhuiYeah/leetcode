package 状态压缩;

//给你一个长度为 2 * n 的整数数组。你需要将 nums 分成 两个 长度为 n 的数组，分别求出两个数组的和，并 最小化 两个数组和之 差的绝对值 。
// nums 中每个元素都需要放入两个数组之一。

import java.util.*;


// 状态压缩 + 折半枚举 + 二分查找
class dee {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2, sum = 0, min = Integer.MAX_VALUE;
        for (int i : nums) sum += i;
        //map 映射 左边区间选择的数字的个数 -> 该数字个数对应的所有和
        var map = new HashMap<Integer, ArrayList<Integer>>();
        //左半区间用哈希表记录,掩码mask唯一标识了一种对左边区间元素的选择情况
        for (int mask = 0; mask < (1 << n); mask++) {
            int tot = 0, cnt = 0; //左半区间的cnt个数字构成了tot总和
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    tot += nums[i];
                    cnt++;
                }
            }
            var set = map.getOrDefault(cnt, new ArrayList<Integer>());
            set.add(tot);
            map.put(cnt, set);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            var list = entry.getValue();
            list.sort((a, b) -> a - b);
            map.put(entry.getKey(), list);
        }
        //右半区间查表
        for (int mask = 0; mask < (1 << n); mask++) {
            int tot = 0, cnt = 0;
            for (int i = n; i < nums.length; i++) {
                if ((mask & (1 << (i - n))) != 0) {
                    tot += nums[i];
                    cnt++;
                }
            }
            //使左右区间选择元素的总数达到n
            var set = map.get(n - cnt);
            //这是超时的原因所在
            //for (int x : set) min = Math.min(min, Math.abs(x + tot - (sum - x - tot)));
            int left = 0, right = set.size() - 1, curmin = Integer.MAX_VALUE;
            //加入二分防超时
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int x = set.get(mid);
                if (2 * x - sum + 2 * tot > 0) {
                    right = mid - 1;
                    curmin = Math.min(curmin, 2 * x - sum + 2 * tot);
                } else if (2 * x - sum + 2 * tot < 0) {
                    left = mid + 1;
                    curmin = Math.min(curmin, -(2 * x - sum + 2 * tot));
                } else {
                    return 0;
                }
            }
            min = Math.min(min, curmin);
        }
        return min;
    }
}


//超时 135/201
public class 折半枚举_将数组分成两个数组并最小化数组和的差 {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2, sum = 0, min = Integer.MAX_VALUE;
        for (int i : nums) sum += i;
        //map 映射 左边区间选择的数字的个数 -> 该数字个数对应的所有和
        var map = new HashMap<Integer, Set<Integer>>();
        //左半区间用哈希表记录,掩码mask唯一标识了一种对左边区间元素的选择情况
        for (int mask = 0; mask < (1 << n); mask++) {
            int tot = 0, cnt = 0; //左半区间的cnt个数字构成了tot总和
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    tot += nums[i];
                    cnt++;
                }
            }
            var set = map.getOrDefault(cnt, new HashSet<>());
            set.add(tot);
            map.put(cnt, set);
        }
        //右半区间查表
        for (int mask = 0; mask < (1 << n); mask++) {
            int tot = 0, cnt = 0;
            for (int i = n; i < nums.length; i++) {
                if ((mask & (1 << (i - n))) != 0) {
                    tot += nums[i];
                    cnt++;
                }
            }
            //使左右区间选择元素的总数达到n
            var set = map.get(n - cnt);
            for (int x : set) min = Math.min(min, Math.abs(x + tot - (sum - x - tot)));
        }
        return min;
    }
}
