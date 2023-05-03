package 动态规划;


//给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
//长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。


//思路和代码真的顶级
public class __两个非重叠子数组的最大和 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];//前i个元素的和
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i]; // prefix[i] : nums[0] ~ nums[i-1]的和
        int[] a = new int[n + 1];//a[i]: nums[0] ~ nums[i-1] 中长度为firstLen的子数组的最大和
        int[] b = new int[n + 1];//前i个元素中 长度为secondlen的子数组的最大和
        int ans = 0;
        for (int i = 1; i <= n; i++) {//前i个元素
            if (i >= firstLen + secondLen) {
                //[i - secondLen , i] 作为secondLen长度的子数组 ， a[i - secondLen]作为firstLen的子数组
                ans = Math.max(ans, prefix[i] - prefix[i - secondLen] + a[i - secondLen]);
                //[i-firstLen , i] 作为 firstLen长度的子数组 ，b[i - firstLen]作为secondLen的子数组
                ans = Math.max(ans, prefix[i] - prefix[i - firstLen] + b[i - firstLen]);
            }
            if (i >= firstLen) a[i] = Math.max(a[i - 1], prefix[i] - prefix[i - firstLen]);
            if (i >= secondLen) b[i] = Math.max(b[i - 1], prefix[i] - prefix[i - secondLen]);
        }
        return ans;
    }
}
