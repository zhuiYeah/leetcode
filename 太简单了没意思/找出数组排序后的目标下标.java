package 太简单了没意思;

import java.util.*;

public class 找出数组排序后的目标下标 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        //映射 数字 和他的所有下标
        Map<Integer, ArrayList<Integer>> indices = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            var myIndex = indices.getOrDefault(nums[i], new ArrayList<Integer>());
            myIndex.add(i);
            indices.put(nums[i], myIndex);
        }
        return indices.getOrDefault(target, new ArrayList<Integer>());
    }
}
