package 位运算;

//314场周赛

//a^b^a = b
//一个数字异或自己偶数次 结果为0
//任何数字异或0 都为该数字本身
public class 找出前缀异或的原始数组 {
    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        res[0] = pref[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = pref[i - 1] ^ pref[i];
        }
        return res;
    }
}
