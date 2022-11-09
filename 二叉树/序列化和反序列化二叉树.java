package 二叉树;

public class 序列化和反序列化二叉树 {
}

class Codeccc {

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

        //if (data.length() == 1) return null;
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

//剑指offer
class Codecccc {

    public static String serialize(TreeNode root) {
        if (root == null) return "#";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + " " + left + " " + right;
    }

    private String[] data;
    private int index;

    public TreeNode deserialize(String data) {
        this.data = data.split(" ");
        if (this.data.length == 0) return null;
        index = 0;
        var fakeRoot = new TreeNode(114);
        dfs(fakeRoot, true);
        return fakeRoot.left;
    }

    //向递归的下级传递他的父节点，以及告诉下级你是作为左子节点还是右子节点
    private void dfs(TreeNode father, boolean isLeft) {
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
