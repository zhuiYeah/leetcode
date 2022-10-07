package 蒸蒸简单;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 多个数组求交集 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums[0]) {
            set.add(i);
        }
        for (int i = 1; i < nums.length; i++) {
            var copy = new HashSet<Integer>();
            for (int j : nums[i]) {
                if (set.contains(j)) {
                    copy.add(j);
                }
            }
            if (copy.size() == 0) return result;
            set.clear();
            set.addAll(copy);
        }
        result.addAll(set);
        result.sort((a, b) -> {
            return a - b;
        });
        return result;
    }
}
