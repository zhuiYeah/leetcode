package 二叉树;

public class _二叉树的堂兄弟节点 {
    int father = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        int xlen = getLength(root, x, 0);
        int xFather = father;
        int ylen = getLength(root, y, 0);
        int yFather = father;
        if (xlen == ylen && xFather != yFather) {
            return true;
        }
        return false;
    }

    public int getLength(TreeNode root, int x, int curDepth) {
        //完全不需要的代码
////        if (root == null) {
////            return -1; //表示没找到
////        }
//        if (root.left == null && root.right == null) { //都搜到叶子结点了，也表示没找到
//            if (root.val == x) {
//                return curDepth;
//            } else {
//                return -1;
//            }
//        }
        if (root.left != null && root.left.val == x) {
            father = root.val;
            return curDepth + 1;
        }
        if (root.right != null && root.right.val == x) {
            father = root.val;
            return curDepth + 1;
        }
        if (root.left != null) {
            int xx = getLength(root.left, x, curDepth + 1);
            if (xx != -1) { //这里判断语句太有必要了，如果左分支没找到的话，不代表整体没有，还要往右分支再找
                return xx;
            }
        }
        if (root.right != null) {
            int xx = getLength(root.right, x, curDepth + 1);
            if (xx != -1) {
                return xx;
            }
        }
        return -1;
    }
}
