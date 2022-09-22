package 二叉树;

import java.util.HashMap;
import java.util.Map;

//前+中 or 后+中 是找 根节点 在中序遍历中的位置
//前+后 是找  左子树的根节点 在后序遍历中的位置
public class 根据前序和后序遍历构造二叉树 {
    int[] preorder;
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return dfs(0, n - 1, 0, n - 1);
    }

    public TreeNode dfs(int L, int R, int l, int r) {
        if (L > R) return null;
        if (L == R) return new TreeNode(preorder[L]);
        var root = new TreeNode(preorder[L]);
        int leftRootVal = preorder[L + 1];
        int index = map.get(leftRootVal);
        int lenOfLeftTree = index - l;
        root.left = dfs(L + 1, L + 1 + lenOfLeftTree, l, l + lenOfLeftTree);
        root.right = dfs(L + 2 + lenOfLeftTree, R, l + lenOfLeftTree + 1, r);
        return root;
    }
}
