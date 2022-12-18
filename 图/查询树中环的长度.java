package 图;

import java.util.HashSet;
//有一颗高度为n的完全二叉树 ， 每个节点按照顺序 1，2，3，4，5，6，7，8，9，10，11 构建，给出两个节点，问连接这两个节点所能构成的环的长度


//思路：找到两个节点的第一个公公祖先即可，用数组储存完全二叉树，每个节点的父亲下标为 （i-1）/2
//图 + 完全二叉树
public class 查询树中环的长度 {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int ptr = -1;//指向res
        for (int[] querie : queries) {
            ptr++;
            //a是较小的，b是较大的，所以a有可能是b的祖先，b不可能是a的祖先
            int a = Math.min(querie[0], querie[1]) - 1;
            int b = Math.max(querie[0], querie[1]) - 1;
            //set储存b向上索引所经过的全部父亲节点，如果遇到0（跟节点｜｜a）则终止向上索引
            var set = new HashSet<Integer>();
            set.add(b);
            while (b != 0 && b != a) {
                b = (b - 1) / 2;
                set.add(b);
            }
            //如果a是b的祖先，那么已成环
            if (b == a) {
                res[ptr] = set.size();
                continue;
            }
            //现在找到 a b 的公共祖先，并记录公祖到a的路径长度
            int cnta = 0;
            while (!set.contains(a)) {
                a = (a - 1) / 2;
                cnta++;
            }
            //计算公共祖先到b的路径长度
            int cntb = 0;
            //现在a是路径的根节点
            for (int ss : set) {
                if (ss > a) cntb++;
            }

            res[ptr] = cntb + cnta + 1;

        }

        return res;

    }
}
