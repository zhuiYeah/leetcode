package _周赛;

import java.util.*;

//来自317场周赛 ， 暴力35/39

//二叉树一共有n个节点，每个节点都有1～n互不相同的值，删除其中的节点i之后二叉树的最大高度为多少？
//n最大为10^5,最大查询10^4次


//本题心得：二叉树的深度与高度是两个完全不同的概念，

//当到达一个节点root时，已知该节点的深度depth，该节点左右子节点的高度，删除该节点后二叉树的最大高度（深度）restheight，
//那么怎么求得删除root.left后的二叉树最大高度呢？

/*已知删除root节点后的二叉树最大高度为restheight，现在不删除root了，删除root.left，这相当于释放了子树root.right，
    情况1 ：root.right子树是会对restheight产生的，从跟节点到root.right子树的最大高度为 depth + (root.right)子树的高度
           并且这个值大于restheight，那么删除左子树之后的最大高度由该节点的右子树贡献
    情况2：restheight很大，depth + (root.right)< restheight,这个高度来自于其他分支，于是释放该节点的右子树对结果不产生影响

    结论，删除root.left后，二叉树的最大高度为 Math.max(restheight,dpeth + (root.right)的高度)

    于是我们进行两次dfs,第一次记录每个点的高度，第二次计算删除每个点后二叉树的最大高度
*/
public class _移除子树后的二叉树高度 {
    private Map<TreeNode, Integer> high;//记录每个节点的高度
    private int[] restH;//restH[i] : 删除节点i之后的最大高度

    public int[] treeQueries(TreeNode root, int[] queries) {
        high = new HashMap<TreeNode, Integer>();
        getLen(root);
        high.put(null, 0);
        restH = new int[high.size() + 1];
        //根节点的深度为1，删除根节点之后二叉树的最大高度为0
        dfs(root, 1, 0);
        for (int i = 0; i < queries.length; i++) {
            queries[i] = restH[queries[i]] - 1;
        }
        return queries;
    }

    private int getLen(TreeNode root) {
        if (root == null) return 0;
        int h = Math.max(getLen(root.left), getLen(root.right)) + 1;
        high.put(root, h);
        return h;
    }

    //递归函数向下层传递他的深度，删除它之后二叉树的最大高度（在父节点就可以计算出来删除其子节点之后的二叉树最大高度）
    private void dfs(TreeNode root, int depth, int restheight) {
        if (root == null) return;
        restH[root.val] = restheight;
        dfs(root.left, depth + 1, Math.max(restheight, depth + high.get(root.right)));
        dfs(root.right, depth + 1, Math.max(restheight, depth + high.get(root.left)));
    }
}


//暴力超时
//    public int[] treeQueries(TreeNode root, int[] queries) {
//        int m = queries.length;
//        int[] res = new int[m];
//        for (int i = 0; i < m; i++) {
//            res[i] = find(root, queries[i]) - 1;
//        }
//        return res;
//    }
//
//    //找到目标节点
//    public int find(TreeNode root, int target) {
//        if (root == null || root.val == target) return 0;
//        int left = find(root.left, target);
//        int right = find(root.right, target);
//        return Math.max(left, right) + 1;
//    }
