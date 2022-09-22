package DFS和BFS;

import java.util.List;

//只适用于二叉树，题目太傻逼
public class dfs_收集树上所有苹果的最少时间 {
    class Node {
        int id;
        boolean hasApple;
        boolean leftHasApple;
        boolean rightHasApple;
        Node left;
        Node right;
    }

    int time = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //先用数组存放n个节点，便于将他们构造成二叉树
        var nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].id = i;
            nodes[i].hasApple = hasApple.get(i);
        }
        //构造二叉树的框架
        for (int i = 0; i < edges.length; i++) {
            Node father = nodes[edges[i][0]];
            Node son = nodes[edges[i][1]];
            if (father.left == null) {
                father.left = son;
            } else {
                father.right = son;
            }
        }
        //补全二叉树的 leftHasApple and rightHasApple
        repairNode(nodes[0]);
        //
        dfs(nodes[0]);
        return time;

    }

    public boolean repairNode(Node root) {
        if (root == null) return false;
        var left = repairNode(root.left);
        var right = repairNode(root.right);
        root.leftHasApple = left;
        root.rightHasApple = right;
        return root.hasApple || root.rightHasApple || root.leftHasApple;
    }

    public void dfs(Node root) {
        if (root.leftHasApple) {
            time++;
            dfs(root.left);
            time++;
        }
        if (root.rightHasApple) {
            time++;
            dfs(root.right);
            time++;
        }
    }

}

////////////////////////////////