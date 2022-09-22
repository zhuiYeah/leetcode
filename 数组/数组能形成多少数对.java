package 数组;

import java.util.HashMap;

public class 数组能形成多少数对 {
    HashMap<Integer, Integer> fre = new HashMap<>();
    int pairs = 0;
    int rest = 0;

    public int[] numberOfPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            fre.put(nums[i], fre.getOrDefault(nums[i], 0) + 1);
        }
        for (HashMap.Entry<Integer, Integer> e : fre.entrySet()) {
            pairs += e.getValue() / 2;
            rest += e.getValue() % 2;
        }
        return new int[]{pairs, rest};
    }
}
