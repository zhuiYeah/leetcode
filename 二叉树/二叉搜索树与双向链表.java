package 二叉树;


import java.util.ArrayList;


public class 二叉搜索树与双向链表 {

    class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ArrayList<Node> list = new ArrayList<Node>();

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);
        int n = list.size();
        if (n == 1) {
            list.get(0).left = list.get(0);
            list.get(0).right = list.get(0);
            return list.get(0);
        }
        list.get(0).left = list.get(n - 1);
        list.get(0).right = list.get(1);
        list.get(n - 1).right = list.get(0);
        list.get(n - 1).left = list.get(n - 2);
        for (int i = 1; i < n - 1; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        return list.get(0);

    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
}

