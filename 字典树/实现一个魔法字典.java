package 字典树;

//剑指offer
public class 实现一个魔法字典 {
}

class MagicDictionary {
//    private MagicDictionary[] children;
//    private boolean isEnd;
//
//    public MagicDictionary() {
//        children = new MagicDictionary[26];
//        isEnd = false;
//    }
//
//    public void buildDict(String[] dictionary) {
//        for (String word : dictionary) {
//            var node = this;
//            for (int i = 0; i < word.length(); i++) {
//                int index = word.charAt(i) - 'a';
//                if (node.children[index] == null) node.children[index] = new MagicDictionary();
//                node = node.children[index];
//            }
//            node.isEnd = true;
//        }
//    }
//
//    public boolean search(String searchWord) {
//
//    }
}


//暴力
class MagicDictionary1 {
    String[] dir;

    public MagicDictionary1() {

    }

    public void buildDict(String[] dictionary) {
        dir = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : dir) {
            if (word.length() != searchWord.length()) continue;
            int diffcount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) diffcount++;
                if (diffcount > 1) break;
            }
            if (diffcount == 1) return true;
        }
        return false;
    }
}
