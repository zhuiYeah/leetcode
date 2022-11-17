package 状态压缩;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//数组能不能分成两个平均值相同的数组
//将数组的每个元素减去该数组的平均值，如果该数组还存在和为0的非空子序列，那么就true（为了避免浮点数，乘以n）
//找出经处理后的数组 是否存在和为0的子序列
//数组最大长为30，纯粹的回溯会超时 ,需要时间换空间

// 状态压缩 + 折半枚举
public class 折半枚举_数组的均值分割 {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, sum = 0;
        if (n == 1) return false;
        for (int i : nums) sum += i;
        for (int i = 0; i < n; i++) nums[i] = nums[i] * n - sum;
        var map = new HashMap<Integer, Integer>();
        int m = n / 2; //左半部分长为m
        //对左半部分的枚举结果一共有 1<<m种 ，除去全部都不选的  ， 即mask=0的时候（因为要找到是否存在和为0的组合）  ，mask的某一位为1代表选择这一位的nums[i]
        for (int mask = 1; mask < (1 << m); mask++) {
            //mask唯一标记了一种对左半部分元素的选择情况
            int tot = 0, cnt = 0; //记录cnt个数字构成了tot和
            for (int i = 0; i < m; i++) {
                if (((1 << i) & mask) != 0) {
                    tot += nums[i];
                    cnt++;
                }
            }
            if (tot == 0 && cnt != 0) return true;
            if (cnt != 0) map.put(tot, Math.min(cnt, map.getOrDefault(tot, Integer.MAX_VALUE)));
        }

        //对右半部分的枚举结果一共有 1<<(n-m)种
        for (int mask = 1; mask < (1 << (n - m)); mask++) {
            int tot = 0, cnt = 0;
            for (int i = m; i < n; i++) {
                if (((1 << (i - m)) & mask) != 0) {
                    tot += nums[i];
                    cnt++;
                }
            }
            if (tot == 0 && cnt != 0) return true;
            if (map.containsKey(-tot) && map.get(-tot) + cnt < n) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);
    }
}


//回溯 + 折半枚举  (与状态压缩的逻辑完全相同，时间复杂度空间复杂度完全相同)
class backtrack {
    int n, m;
    int[] nums;
    Map<Integer, Integer> map;
    boolean res = false; //可以利用res为true的判定条件终止递归

    public boolean splitArraySameAverage(int[] nums) {
        n = nums.length;
        if (n == 1) return false;
        m = n / 2;
        this.nums = nums;
        int sum = 0;
        for (int i : nums) sum += i;
        for (int i = 0; i < nums.length; i++) nums[i] = nums[i] * n - sum;
        map = new HashMap<>();

        initmap(0, 0, 0);
        if (res) return true;
        dfs(m, 0, 0);
        return res;
    }

    public void initmap(int index, int tot, int cnt) {
        if (index == m + 1) return;
        if (cnt != 0) map.put(tot, Math.min(cnt, map.getOrDefault(tot, Integer.MAX_VALUE)));
        if (tot == 0 && cnt != 0) res = true;
        if (res) return; //利用res来终止递归
        initmap(index + 1, tot, cnt);//不选 index元素
        initmap(index + 1, tot + nums[index], cnt + 1); //选择index元素
    }

    public void dfs(int index, int tot, int cnt) {
        if (tot == 0 && cnt != 0) res = true;
        if (res) return;
        if (map.containsKey(-tot) && map.get(-tot) + cnt < n) res = true;
        //if (res) return;
        if (index == n) return;
        dfs(index + 1, tot, cnt);
        dfs(index + 1, tot + nums[index], cnt + 1);
    }
}

class test {
    public static void main(String[] args) {
        var x = new backtrack();
        x.splitArraySameAverage(new int[]{18, 0, 16, 2});
    }
}
