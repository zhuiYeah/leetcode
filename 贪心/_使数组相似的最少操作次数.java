package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
//来自316场周赛
//对nums数组中的两个数字进行+2 -2；使得nums数组相似于target数组（所有数字出现频率相同），那么最少操作次数是多少次？


//对于nums中的每个数字，如果可以找到它要变成的target，那么记录所有nums[i]与target[j]之间的差值绝对值之和为diff，结果就是diff/4;
//就是要找到距离nums[i]最近的target[j] ，题目说会 $给定的nums和target一定能够完成转化$
// ，于是,排序后的nums和target其实是两个面积相等的梯形

//贪心，要定位到当前数字需要变为的target数字，这个数字就是target数组经过排序后的第一个数字，周赛愣是没想出来
class edewc {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        var ou = new ArrayList<Integer>();
        var ji = new ArrayList<Integer>();
        for (int j : target) {
            if (j % 2 == 0) {
                ou.add(j);
            } else {
                ji.add(j);
            }
        }
        long count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count += Math.max(0, ou.get(0) - num);
                ou.remove(0);
            } else {
                count += Math.max(0, ji.get(0) - num);
                ji.remove(0);
            }
        }
        return count / 2;
    }
}


//错误
public class _使数组相似的最少操作次数 {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        var tar = new ArrayList<Integer>();
        for (int j : target) tar.add(j);
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            int me = nums[i];
            int minDiff = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < tar.size(); j++) {
                if (tar.get(j) == me) {
                    minDiff = 0;
                    index = j;
                    break;
                } else if (tar.get(j) < me) {
                    if ((me - tar.get(j)) % 2 == 1) continue;
                    if (me - tar.get(j) <= minDiff) {
                        minDiff = me - tar.get(j);
                        index = j;
                    } else {
                        break;
                    }
                } else {
                    if ((tar.get(j) - me) % 2 == 1) continue;
                    if (tar.get(j) - me < minDiff) {
                        minDiff = tar.get(j) - me;
                        index = j;
                    } else {
                        break;
                    }
                }
            }
            diff += minDiff;
            tar.remove(index);
        }
        return diff / 4;
    }
}

//错误
class wswdxw {
    public long makeSimilar(int[] nums, int[] target) {
        var mapji = new TreeMap<Integer, Integer>();
        var mapou = new TreeMap<Integer, Integer>();

        for (int i = 0; i < target.length; i++) {
            if (target[i] % 2 == 0) {
                mapou.put(target[i], mapou.getOrDefault(target[i], 0) + 1);
            } else {
                mapji.put(target[i], mapji.getOrDefault(target[i], 0) + 1);
            }
        }
        long res = 0;
        var unused = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (mapou.containsKey(nums[i])) {
                    int count = mapou.get(nums[i]);
                    if (count == 1) {
                        mapou.remove(nums[i]);
                    } else {
                        mapou.put(nums[i], count - 1);
                    }
                    continue;
                }
                int up = 0, down = 0;
                if (mapou.higherKey(nums[i]) != null) {
                    up = mapou.higherKey(nums[i]);
                }
                if (mapou.lowerKey(nums[i]) != null) {
                    down = mapou.lowerKey(nums[i]);
                }
                if (up == 0) {
                    res += nums[i] - down;
                    int count = mapou.get(nums[i]);
                    if (count == 1) {
                        mapou.remove(nums[i]);
                    } else {
                        mapou.put(nums[i], count - 1);
                    }
                }
            } else {
                if (mapji.containsKey(nums[i])) {
                    int count = mapji.get(nums[i]);
                    if (count == 1) {
                        mapji.remove(nums[i]);
                    } else {
                        mapji.put(nums[i], count - 1);
                    }
                    continue;
                }
            }


        }
        return 0;
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//大佬写法
class wdew {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        long count = 0;
        for (int i = 0, ou = -1, ji = -1; i < nums.length; i++) {
            while (nums[i] % 2 == 1 && target[++ou] % 2 == 0) ;
            while (nums[i] % 2 == 0 && target[++ji] % 2 == 1) ;
            count += Math.max(0, (nums[i] - target[nums[i] % 2 == 1 ? ou : ji]) / 2);
        }
        return count;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////
