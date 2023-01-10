package 字典树;

//2479分

//纯暴力超时 ， 54/63
public class ____统计异或值在范围内的数对有多少 {
    public int countPairs(int[] nums, int low, int high) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            for (int j = i + 1; j < n; j++) {
                int b = nums[j];
                int x = a ^ b;
                if (x >= low && x <= high) cnt++;
            }
        }

        return cnt;
    }
}


class dewfew {

    class Trie {
        // son[0] 表示左子树，son[1] 表示右子树
        Trie[] son = new Trie[2];
        int sum;//表示在当前k位 为0或者为1的 数字一共有sum个

        public Trie() {
            sum = 0;
        }
    }

    private Trie root = null;   // 字典树的根节点
    private static final int HIGH_BIT = 14;  // 最高位的二进制位编号为 14

    public int countPairs(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }

    //f(x):计算 异或和小于等于 x 的数字对 的数量
    public int f(int[] nums, int x) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += get(nums[i], x);
        }
        return res;
    }

    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;//当前是该数字的第k位，第k位的bit仅可能为0或1
            if (cur.son[bit] == null) cur.son[bit] = new Trie();
            cur = cur.son[bit];
            cur.sum++;
        }
    }

    //计算f（x）：异或和小于等于 x 的数字对 的数量 ， num能给出的贡献是多少(num能和多少数字组成数字对)
    public int get(int num, int x) {
        Trie cur = root;
        int sum = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (((x >> k) & 1) != 0) {
                if (cur.son[bit] != null) sum += cur.son[bit].sum;
                if (cur.son[1 - bit] == null) return sum; //？？？
                cur = cur.son[1 - bit];
            } else {
                if (cur.son[bit] == null) return sum;
                cur = cur.son[bit];
            }
        }
        sum += cur.sum;
        return sum;
    }
}
