package 字典树;

public class 实现Trie前缀树 {
}

//剑指offer
class Trie {
    private Trie[] children;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) node.children[index] = new Trie();
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        var x = searchPrefix(word);
        return x != null && x.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    //搜索给定单词的最短前缀
    public String searchTheMinPrefix(String word) {
        var node = this;
        int end = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) break;
            node = node.children[index];
            if (node.isEnd) {
                end = i+1;
                break;
            }
        }
        return word.substring(0, end);
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }
}

