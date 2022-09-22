package 贪心;

import java.util.Set;
import java.util.TreeSet;

//贪心贪的是一次遍历中的最小值
//但贪心没写出来 失败
public class 递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        int min = nums[0];
        int theNumOfHigherMin = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                theNumOfHigherMin = 0;
            } else if (nums[i] > min) {
                min = nums[i];
                theNumOfHigherMin++;
                if (theNumOfHigherMin == 2) return true;
            }
        }
        return false;
    }
}

////////////////////////////////////////////////////////////////
//试一下动态规划吧
//本来想写动态规划的，但是悟出了贪心的思路
class swdwed {
    public boolean increasingTriplet(int[] nums) {
        //记录能构成三元组的第一个数字的最小值
        int a = nums[0];
        //记录能构成三元组的第二个数字的最小值
        int b = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            //这表明找到三元组的最后一个数字了
            if (nums[i] > b) return true;
            //现在当前数字不可以作为三元组的最后一个数字
            //表明当前数字可以作为三元组的第二个数字
            if (nums[i] > a) {
                b = Math.min(nums[i], b);
            }
            //当前数字可以作为三元组的第一个数字
            a = Math.min(a, nums[i]);
        }
        return false;
    }
}
