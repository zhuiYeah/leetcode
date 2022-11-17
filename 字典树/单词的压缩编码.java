package 字典树;


public class 单词的压缩编码 {
    class Node {
        boolean isStart;
        Node[] children;

        public Node() {
            children = new Node[26];
            isStart = false;
        }

        public void insert(String word) {
            var node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) node.children[index] = new Node();
                node = node.children[index];
                node.isStart = false;
            }
            boolean xx = true;//是叶子节点吗
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    xx = false;
                    break;
                }
            }
            if (xx) node.isStart = true;
        }
    }

    int res = 0;

    public int minimumLengthEncoding(String[] words) {
        var tree = new Node();
        for (String word : words) tree.insert(word);
        dfs(tree, 0);
        return res;
    }

    private void dfs(Node node, int depth) {
        if (node == null) return;
        //叶子节点计算深度
        if (node.isStart) {
            res += depth + 1;
            return;
        }
        for (int i = 0; i < 26; i++) {
            dfs(node.children[i], depth + 1);
        }
    }
}
