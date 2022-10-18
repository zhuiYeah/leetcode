package 二分查找;

//89场双周赛
//从前往后的 ， 可以将当前值的一部分向前进行分配 ， 由此获得最大程度的这样操作之后的 数组最大值（越小越好）

//错误
public class 二分答案_最小化数组中的最大值 {
    public int minimizeArrayValue(int[] nums) {
        int max = nums[0];
        int maxNum = 1;
        int noMax = 0;
        int noMaxNum = 0;
        if (nums[0] > nums[1]) {
            max = nums[0];
            noMax = nums[1];
        } else if (nums[0] < nums[1]) {
            if ((nums[0] + nums[1]) % 2 == 0) {
                max = (nums[0] + nums[1]) / 2;
                noMax = max;
            } else {
                max = (nums[0] + nums[1]) / 2 + 1;
                noMax = (nums[0] + nums[1]) / 2;
            }
        }
        for (int i = 2; i < nums.length; i++) {
            if (noMax + nums[i] < max) {
                noMax += nums[i];
                continue;
            } else if (noMax + nums[i] == max) {
                maxNum++;
                noMax = 0;
                continue;
            } else {
                maxNum++;
                noMax = 0;
                nums[i] -= max - noMax;
            }
            if (nums[i] == max) {
                maxNum++;
            } else if (nums[i] < max) {
                noMax = nums[i];
            } else {
                maxNum++;
                nums[i] -= max;
                int add = nums[i] / maxNum;
                max += add;
                int rest = nums[i] % maxNum;
                if (rest != 0) {
                    max++;
                    //现在有rest个max 和 maxNum - rest 个 max -1，将max-1尽可能多的变成max
                }
            }
        }
        return max;
    }
}


class uyfty {
    public int minimizeArrayValue(int[] nums) {
        int max = nums[0];
        int count = 1;
        long sum = nums[0];
        int xx = 0;
        for (int i = 1; i < nums.length; i++) {
            count++;
            sum += (long) nums[i];
            if (nums[i] > max) {
                //不理解sum + count - 1是怎么来的
                xx = (int) ((sum + count - 1) / count);
                max = Math.max(xx, max);
            }
        }
        return max;
    }
}


////错误
class uyftssy {
    public int minimizeArrayValue(int[] nums) {
        int max = nums[0];
        int count = 1;
        long sum = nums[0];
        int xx = 0;
        for (int i = 1; i < nums.length; i++) {
            count++;
            sum += (long) nums[i];
            if (nums[i] > max) {
                if ((sum % count) == 0) {
                    xx = (int) (sum) / count;
                } else {
                    xx = (int) (sum / count) + 1;
                }
                max = Math.max(xx, max);
            }
        }
        return max;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
//二分答案
//根本没想到二分
//0 <= nums[i] <= 10^9,于是最极端的情况是最小化数组的最大值之后 数组的最大值为0或者10^9;
//于是对答案范围 0 ～ 10^9 进行二分查找
//问题变为 数字mid能否从前向后的填满这个数组 ， 找到满足条件的mid的最小值
class Solution {
    int[] nums;

    public int minimizeArrayValue(int[] nums) {
        this.nums = nums;
        int left = 0, right = 1000000000;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    //最大值为limit，能否填满
    public boolean check(int limit) {
        //have表示当前有多少容量可以给大于n的数字进行分配
        long have = 0;
        for (int cur : nums) {
            if (cur <= limit) {
                have += limit - cur;
            } else if (cur > limit) {
                if (have >= cur - limit) {
                    have -= cur - limit;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}


