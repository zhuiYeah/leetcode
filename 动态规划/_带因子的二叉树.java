package 动态规划;

import java.util.*;

//9.12
//通过案例 42/48
public class _带因子的二叉树 {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        //dp[i]：以array[i]作为二叉树的根节点，可以组成的不同的乘积二叉树的个数为dp[i]
        Arrays.fill(dp, 1);
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();//映射根节点的值 - 》 能组成该根节点值的两个因子
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(); //做到arr数组的反向映射
        //初始化哈希表
        for (int i = 0; i < n; i++) {
            map.put(arr[i], new ArrayList<>());
        }
        //完成哈希表
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (map.containsKey(arr[j] * arr[i])) {
                    var x = map.get(arr[j] * arr[i]);
                    x.add(arr[i]);
                    x.add(arr[j]);
                    map.put(arr[j] * arr[i], x);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            map2.put(arr[i], i);
        }
        //开始动态规划
        for (int i = 0; i < n; i++) {
            var x = map.get(arr[i]);
            for (int j = 0; j < x.size(); j += 2) {
                int num1 = x.get(j);
                int num2 = x.get(j + 1);
                int index1 = map2.get(num1);
                int index2 = map2.get(num2);
                if (num1 == num2) {
                    dp[i] = (dp[i] + dp[index1] * dp[index2]) % 1000000007;
                } else {
                    dp[i] = (dp[i] + 2 * (dp[index1] * dp[index2])) % 1000000007;
                }
            }
        }
        return (int) Arrays.stream(dp).sum() % 1000000007;
    }
}


//------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------


class Solution3 {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x : dp) ans += x;
        return (int) (ans % MOD);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
// 42/48
class defdedw {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        //dp[i]：以array[i]作为二叉树的根节点，可以组成的不同的乘积二叉树的个数为dp[i]
        Arrays.fill(dp, 1);
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();//映射根节点的值 - 》 能组成该根节点值的两个因子
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(); //做到arr数组的反向映射
        //初始化哈希表
        for (int i = 0; i < n; i++) {
            map.put(arr[i], new ArrayList<>());
        }
        //完成哈希表
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (map.containsKey(arr[j] * arr[i])) {
                    var x = map.get(arr[j] * arr[i]);
                    x.add(arr[i]);
                    x.add(arr[j]);
                    map.put(arr[j] * arr[i], x);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            map2.put(arr[i], i);
        }
        //开始动态规划
        long res = 0;
        for (int i = 0; i < n; i++) {
            var x = map.get(arr[i]);
            for (int j = 0; j < x.size(); j += 2) {
                int num1 = x.get(j);
                int num2 = x.get(j + 1);
                int index1 = map2.get(num1);
                int index2 = map2.get(num2);
                if (num1 == num2) {
                    dp[i] = (dp[i] + (dp[index1] * dp[index2]) % 1000000009) % 1000000007;
                } else {
                    dp[i] = (dp[i] + 2 * (dp[index1] * dp[index2]) % 1000000007) % 1000000007;
                }
            }
            res = (res + dp[i]) % 1000000007;
        }
        return (int) res;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//9.20
//47/48
class defdedwdw {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        //dp[i]：以array[i]作为二叉树的根节点，可以组成的不同的乘积二叉树的个数为dp[i]
        Arrays.fill(dp, 1);
        Map<Long, List<Integer>> map = new HashMap<>();//映射根节点的值 - 》 能组成该根节点值的两个因子
        Map<Long, Integer> map2 = new HashMap<>(); //做到arr数组的反向映射
        //初始化哈希表
        for (int i = 0; i < n; i++) {
            map.put((long) arr[i], new ArrayList<>());
        }
        //完成哈希表
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (map.containsKey((long) arr[j] * arr[i])) {
                    var x = map.get((long) arr[j] * arr[i]);
                    x.add(arr[i]);
                    x.add(arr[j]);
                    map.put(((long) arr[j] * arr[i]), x);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            map2.put((long) arr[i], i);
        }
        //开始动态规划
        long res = 0;
        for (int i = 0; i < n; i++) {
            var x = map.get((long) arr[i]);
            for (int j = 0; j < x.size(); j += 2) {
                int num1 = x.get(j);
                int num2 = x.get(j + 1);
                int index1 = map2.get((long) num1);
                int index2 = map2.get((long) num2);
                if (num1 == num2) {
                    dp[i] = (dp[i] + (dp[index1] * dp[index2]) % 1000000009) % 1000000007;
                } else {
                    dp[i] = (dp[i] + 2 * (dp[index1] * dp[index2]) % 1000000007) % 1000000007;
                }
            }
            res = (res + dp[i]) % 1000000007;
        }
        return (int) res;
    }
}
