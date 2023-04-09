package 链蒸蒸简单;

import java.util.Arrays;

public class 检查相同字母间的距离 {
    public boolean checkDistances(String s, int[] distance) {
        int[] realDis = new int[26];
        int[] preIndex = new int[26];
        Arrays.fill(preIndex, -1);
        Arrays.fill(realDis, -1);
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (preIndex[idx] == -1) {
                preIndex[idx] = i;
            } else {
                realDis[idx] = i - preIndex[idx] - 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (realDis[i] == -1) continue;
            if (realDis[i] != distance[i]) return false;
        }
        return true;
    }
}
