package 二叉树;

import java.util.*;

//因为对每个节点都去重新构造序列，重复计算太多了
public class _寻找重复的子树 {
    List<TreeNode> res = new ArrayList<TreeNode>();
    //set存放二叉树中 所有节点 作为根节点遍历 的序列
    Set<String> set = new HashSet<String>();
    //map映射 重复子树的序列 ->该重复子树的其中之一根节点
    Map<String, TreeNode> map = new HashMap<String, TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorder(root);
        for (Map.Entry<String, TreeNode> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        String s = constructXuLie(root);
        if (set.contains(s)) {
            map.put(s, root);
        } else {
            set.add(s);
        }
        preorder(root.left);
        preorder(root.right);
    }

    public String constructXuLie(TreeNode root) {
        if (root == null) return "*";
        String s = String.valueOf(root.val);
        String left = constructXuLie(root.left);
        String right = constructXuLie(root.right);
        return s + "->+" + left + "->" + right + "->";
    }
}

////////////////////    ///////////////////////////////////////////////
//上面的解每一个节点都去构建序列，太多重复计算了
//想到后续遍历，节点构造完自己的序列后，向父节点返回自己的序列结果给父节点使用
class huuhu {
    List<TreeNode> res = new ArrayList<TreeNode>();
    //set存放二叉树中 所有节点 作为根节点遍历 的序列
    Set<String> set = new HashSet<String>();
    //map映射 重复子树的序列 ->该重复子树的其中之一根节点
    Map<String, TreeNode> map = new HashMap<String, TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        for (Map.Entry<String, TreeNode> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String s = String.valueOf(root.val);
        String left = dfs(root.left);
        String right = dfs(root.right);
        String ss = s + "-" + left + "-" + right + "-";
        if (set.contains(ss)) { //出现了重复序列ss，哈希表中映射 重复序列 -》 序列的根节点
            map.put(ss, root);
        } else {
            set.add(ss);  //序列ss第一次出现
        }
        return ss;
    }

}
