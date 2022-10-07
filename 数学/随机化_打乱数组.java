package 数学;

import java.util.ArrayList;
import java.util.Random;

public class 随机化_打乱数组 {

}

//暴力

class Solutionx {
    int[] nums;
    int[] defaultNums;

    public Solutionx(int[] nums) {
        this.nums = nums;
        this.defaultNums = nums.clone();
    }

    public int[] reset() {
        nums = defaultNums;
        return nums;
    }

    public int[] shuffle() {
        var shuffle = new int[nums.length];
        var list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        //产生一个[0,1)之间的随机数
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            //index 是在[0,list.size())之内的随机整数
            int index = random.nextInt(list.size());
            shuffle[i] = list.remove(index);
        }
        nums = shuffle;
        return nums;
    }
}


////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
//Fisher-Yates 洗牌算法
class Solution {
    int[] nums;
    int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
    }

    public int[] reset() {
        nums = original.clone();
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
