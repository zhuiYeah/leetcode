package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class bfs填充每个节点的下一个右侧节点指针II {
    public Node connect(Node root) {
        if (root == null) return null;
        var queue = new ArrayDeque<Node>();
        queue.add(root);
        root.next = null;
        ArrayList<Node> thisLayer = new ArrayList<Node>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                thisLayer.add(cur);
                assert cur != null;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            for (int i = 0; i < n - 1; i++) {
                thisLayer.get(i).next = thisLayer.get(i + 1);
            }
            thisLayer.get(n - 1).next = null;
            thisLayer.clear();
        }
        return root;
    }
}
