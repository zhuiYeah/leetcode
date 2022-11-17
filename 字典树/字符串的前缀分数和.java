package 字典树;

public class 字符串的前缀分数和 {
    class Trie {
        Trie[] children;
        int quan;

        public Trie() {
            children = new Trie[26];
            quan = 0;
        }

        public void insert(String word) {
            var node = this;
            for (int i = 0; i < word.length(); i++) {
                var index = word.charAt(i) - 'a';
                if (node.children[index] == null) node.children[index] = new Trie();
                node = node.children[index];
                node.quan++;
            }
        }

        public int getQuan(String word) {
            var node = this;
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                var index = word.charAt(i) - 'a';
                node = node.children[index];
                sum += node.quan;
            }
            return sum;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        var dictree = new Trie();
        for (String word : words) dictree.insert(word);
        int[] result = new int[words.length];
        for (int i = 0; i < result.length; i++) result[i] = dictree.getQuan(words[i]);
        return result;
    }
}
