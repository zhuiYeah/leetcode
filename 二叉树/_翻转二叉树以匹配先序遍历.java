package 二叉树;

import java.util.*;

//写了蛮久的
public class _翻转二叉树以匹配先序遍历 {
    int[] voyage;
    List<Integer> res = new ArrayList<Integer>();
    int curIndex = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        if (dfs(root)) {
            return res;
        }
        res.clear();
        res.add(-1);
        return res;
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return true;
//        if (root.left == null && root.right == null) {
//            if (root.val == voyage[curIndex]) {
//                curIndex++;
//                return true;
//            }
//            return false;
//        }
        if (root.val != voyage[curIndex]) {
            return false;
        }
        curIndex++;
//        if (root.left == null) {
//            if (!dfs(root)) {
//                return false;
//            }
//        }
//        if (root.right == null) {
//            if (!dfs(root.left)) {
//                return false;
//            }
//        }
        //当前节点值等于curIndex
        if (!dfs(root.left)) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;
            res.add(root.val);
            if (!dfs(root.left)) {
                return false;
            }
        }
        if (!dfs(root.right)) {
            return false;
        }
        return true;
    }

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
//curindex必须作为全局变量记录，下面作为局部变量传递是错误的
class curindex {
    int[] voyage;
    List<Integer> res = new ArrayList<Integer>();
    int curIndex = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        if (dfs(root, 0)) {
            return res;
        }
        res.clear();
        res.add(-1);
        return res;
    }

    public boolean dfs(TreeNode root, int curIndex) {
        if (root == null) return true;

        if (root.val != voyage[curIndex]) {
            return false;
        }
        curIndex++;

        //当前节点值等于curIndex
        if (!dfs(root.left, curIndex)) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;
            res.add(root.val);
            if (!dfs(root.left, curIndex)) {
                return false;
            }
        }
        if (!dfs(root.right, curIndex)) {
            return false;
        }
        return true;
    }
}
