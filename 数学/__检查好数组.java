package 数学;

//给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
//
//        假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。

/**
 * 题目给出一个正整数数组 nums\textit{nums}nums，现在我们需要从中任选一些子集，然后将子集中的每一个数都乘以一个任意整数并求出他们的和，如果该和的结果为 111，那么原数组就是一个「好数组」。现在我们需要判断数组 nums\textit{nums}nums 是否是一个「好数组」。由「裴蜀定理」可得，题目等价于求 nums\textit{nums}nums 中的全部数字的最大公约数是否等于 111，若等于 111 则原数组为「好数组」，否则不是。
 * <p>
 * 求 nums\textit{nums}nums 中全部数字的最大公约数的方法为，我们设初始为 x=nums[0]x = \textit{nums}[0]x=nums[0]，然后对于每一个数 nums[i]\textit{nums}[i]nums[i]，0<i<n0 < i < n0<i<n，我们更新 x=gcd⁡(x,nums[i])x = \gcd(x, \textit{nums}[i])x=gcd(x,nums[i])。遍历完全部数字后，xxx 即为数组 nums\textit{nums}nums 中全部的元素的最大公约数。然后判断其是否等于 111 即可。在实现过程中我们也可以进一步做优化：如果遍历过程中出现最大公约数等于 111 的情况，则由于 111 和任何正整数的最大公约数都是 111，此时可以提前结束遍历。
 */
public class __检查好数组 {
    public boolean isGoodArray(int[] nums) {
        int x = nums[0];
        for (int i : nums) {
            if ((x = gcd(x, i)) == 1) return true;
        }
        return false;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
