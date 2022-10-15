package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class N叉树的层序遍历 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(Node root) {
        res = new ArrayList<List<Integer>>();
        var queue = new ArrayDeque<Node>();
        if (root == null)  return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            var path = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                assert cur != null;
                path.add(cur.val);
                queue.addAll(cur.children);
            }
            res.add(path);
        }
        return res;
    }
}
