package 二叉树;

import java.util.*;

//本题最大的收获是 如何从一个 字符串序列中恢复一个二叉树（利用dfs）
//本方法从一个前序遍历的二叉树序列中 恢复二叉树 ，适用于所有的二叉树而不仅仅是二叉搜索树
class Codec {


    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        var left = serialize(root.left);
        var right = serialize(root.right);

        return root.val + " " + left + " " + right;
    }

    String[] data;
    int index;

    public TreeNode deserialize(String data) {
        this.data = data.split(" ");

        if (data.length() == 1) return null;
        index = 0;
        var fakeRoot = new TreeNode(114514);
        dfs(fakeRoot, true);
        return fakeRoot.left;
    }

    //向递归的下级传递他的父节点，以及告诉下级你是作为左子节点还是右子节点
    public void dfs(TreeNode father, boolean isLeft) {
        if (data[index].equals("#")) {
            index++;
            return;
        }
        var son = new TreeNode(Integer.parseInt(data[index]));
        if (isLeft) {
            father.left = son;
        } else {
            father.right = son;
        }
        index++;
        dfs(son, true);
        dfs(son, false);
    }
}

//    public static void main(String[] args) {
//        var root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        var s = serialize(root);
//        System.out.println(s);
//    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//我们知道，从前序遍历和中序遍历可以唯一的确定一颗二叉树
//而只要知道二叉树的前序遍历，就可以立刻推出二叉搜索树的中序遍历
//所以在序列化的时候，只需要保存二叉搜索树的前序遍历结果

//太麻烦了不想写了
//问题应该处在String 到int数组的转换出了问题
class Codecc {
    public String serialize(TreeNode root) {
        var list = new ArrayList<Integer>();
        inorder(root, list);
        if (list.size() == 0) {
            return "";
        }
        var sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode deserialize(String data) {
        String[] s = data.split(" ");
        int[] preorder = new int[s.length];
        for (int i = 0; i < preorder.length; i++) {
            preorder[i] = Integer.parseInt(s[i]);
        }
        var inorder = preorder.clone();
        Arrays.sort(inorder);
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    //从前序遍历和中序遍历恢复一颗二叉树
    public TreeNode dfs(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        int rootVal = preorder[preorder_left];
        var root = new TreeNode(rootVal);
        int inorder_root = map.get(rootVal);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = dfs(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = dfs(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public static void main(String[] args) {
        String ss = "1 2 3 4 5";
        String[] s = ss.split(" ");
        int[] preorder = new int[s.length];
        for (int i = 0; i < preorder.length; i++) {
            preorder[i] = Integer.parseInt(s[i]);
        }
        System.out.println(Arrays.toString(preorder));
    }

}
