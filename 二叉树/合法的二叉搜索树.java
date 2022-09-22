package 二叉树;

//二叉搜索树是严格递增的呀原来
//原来对本题的思路仅仅是先中序遍历获得一个数组，然后判断该数组是否是递增的
//但其实，中序遍历也是一种顺序的遍历呀，在每次遍历的过程中判断当前元素是否符合规则！
public class 合法的二叉搜索树 {
    long frontValue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= frontValue) {
            //如果当前遍历到的值比前一个值小或相等，那么这就不是一个二叉搜索树
            return false;
        } else {
            //否则更新frontValue
            frontValue = root.val;
        }
        if (!isValidBST(root.right)) {
            return false;
        }
        //只要你能往回走，往下继续搜，说明目前为止还是合法的二叉搜索树
        return true;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//按照二叉搜索树的性质（左小右大） 的 思路
class dswdwdsw {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
//        if (!dfs(root.left, min, root.val)) {
//            return false;
//        }
//        if (!dfs(root.right, root.val, max)) {
//            return false;
//        }
//        return true;
        //以上被注释掉的部分总结起来就是这么一行
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}

