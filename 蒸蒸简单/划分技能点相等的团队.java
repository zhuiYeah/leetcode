package 蒸蒸简单;

import java.util.Arrays;

//将长为n的数组  分成n/2组 ，每组 2个 ，使得所有组的和相等 ，返回所有组的积之和
public class 划分技能点相等的团队 {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int sum = 0;
        for (int j : skill) sum += j;
        n /= 2; //共n组
        if (sum % n != 0) return -1;
        int pre = sum / n; //每组得分pre
        long res = 0;
        int l = 0, r = skill.length - 1;
        Arrays.sort(skill);
        while (l < r) {
            if (skill[l] + skill[r] != pre) return -1;
            res += (long) skill[l] * skill[r];
            l++;
            r--;
        }
        return res;
    }
}
