package 哈希表;

import java.util.HashMap;


public class 最大相等频率 {
    int res = 0;
    int maxFre = 0; //记录当前的最大频率
    HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> fre = new HashMap<Integer, Integer>();

    public int maxEqualFreq(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) {
                count.put(nums[i], 1);
                fre.put(1, fre.getOrDefault(1, 0) + 1);
                maxFre = Math.max(maxFre, 1);
            } else {
                fre.put(count.get(nums[i]), fre.get(count.get(nums[i])) - 1);
                count.put(nums[i], count.get(nums[i]) + 1);
                maxFre = Math.max(maxFre,count.get(nums[i]));
                fre.put(count.get(nums[i]), fre.getOrDefault(count.get(nums[i]), 0) + 1); //等价于go中的fre[count[nums[i]]]++
            }
            boolean ok = maxFre == 1 ||
                    fre.get(maxFre) * maxFre + fre.get(maxFre - 1) * (maxFre - 1) == i + 1 && fre.get(maxFre) == 1 ||
                    fre.get(1) + fre.get(maxFre) * maxFre == i + 1 && fre.get(1) == 1;

            if (ok) {
                res = i + 1;
            }
        }

        return res;
    }
}

