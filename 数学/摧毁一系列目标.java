package 数学;

import java.util.*;

//来自90场双周赛 ， 超出内存限制4次后

//取模分组

//取模，如果这个模非常大的话（10^9）,那么用一个这么大的数组存模必定会超出内存限制，所以用
// 哈希表记录取mod后的数字 -> 出现次数
//    取mod后的数字 -> 对应的最小数字
public class 摧毁一系列目标 {
    public int destroyTargets(int[] nums, int space) {
        Arrays.sort(nums);
        int max = 0;
        int[] map = new int[100000];//映射出现次数
        int[] xx = new int[100000];
        Arrays.fill(xx, Integer.MAX_VALUE);
        for (int num : nums) {
            int index = num % space;
            if (index >= 100000) continue;
            if (xx[index] == Integer.MAX_VALUE) xx[index] = num;
            map[index]++;
            if (map[index] > max) max = map[index];
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 100000; i++) {
            if (map[i] == max){
                min = Math.min(min, xx[i]);
            }
        }
        return min;
    }
}
