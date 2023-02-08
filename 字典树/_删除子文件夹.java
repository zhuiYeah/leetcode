package 字典树;

import java.util.*;

//这里错在字典树内部数据结构的设计

//超时的字典树写法
//class Trie1 {
//    private List<Trie1> children;
//    private String value;
//    private boolean isEnd;
//
//    public Trie1(String s) {
//        children = new ArrayList<>();
//        isEnd = false;
//        value = s;
//    }
//
//    public void insert(String s) {
//        var node = this;
//        var ss = s.split("/");
//        for (String x : ss) {
//            var foundSon = false;
//            for (Trie1 son : node.children) {
//                if (son.value.equals(x)) {
//                    node = son;
//                    foundSon = true;
//                    break;
//                }
//            }
//            if (!foundSon) {
//                node.children.add(new Trie1(x));
//                node = node.children.get(node.children.size() - 1);
//            }
//        }
//        node.isEnd = true;
//    }
//
//    public boolean isSubDir(String s) {
//        var node = this;
//        var ss = s.split("/");
//        for (String x : ss) {
//            var foundSon = false;
//            for (Trie1 son : node.children) {
//                if (!son.value.equals(x)) continue;
//                foundSon = true;
//                if (son.isEnd) {
//                    return true;
//                } else {
//                    node = son;
//                    break;
//                }
//            }
//            if (!foundSon) return false;
//        }
//        return node.isEnd;
//    }
//}
//
//public class 删除子文件夹 {
//
//    public List<String> removeSubfolders(String[] folder) {
//        Arrays.sort(folder, (a, b) -> a.compareTo(b));
//        var head = new Trie1("fuck");
//        var res = new ArrayList<String>();
//        for (String s : folder) {
//            if (!head.isSubDir(s)) res.add(s);
//            head.insert(s);
//        }
//        return res;
//    }
//}


//class dfrefer {
//    public static void main(String[] args) {
//        new 删除子文件夹().removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"});
//    }
//}


/**
 * 每个节点仅包含单个小写字母的经典字典树设计 children = new Trie[26]
 * 当节点的值很复杂时  children = new HashMap<String,Trie>()
 * */
class 非字典树做法 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a, b) -> a.compareTo(b));
        var set = new HashSet<String>();
        var res = new ArrayList<String>();
        for (String s : folder) {
            int n = s.length();
            boolean isSub = false;
            for (int i = 1; i < n; i++) {
                char c = s.charAt(i);
                if (c == '/' && set.contains(s.substring(0, i))) {
                    //确定是子文件夹了
                    isSub = true;
                    break;
                }
            }
            set.add(s);
            if (!isSub) res.add(s);
        }
        return res;
    }
}


class Trie1 {
    boolean isEnd;
    Map<String, Trie1> children;


    public Trie1() {
        isEnd = false;
        children = new HashMap<String, Trie1>();
    }

    public void insert(String path) {
        var pathSplit = path.split("/");
        var cur = this;
        for (String s : pathSplit) {
            cur.children.putIfAbsent(s, new Trie1());
            cur = cur.children.get(s);
        }
        cur.isEnd = true;
    }

    public boolean isSub(String path) {
        var pathSplit = path.split("/");
        var cur = this;
        for (String s : pathSplit) {
            if (cur.children.containsKey(s)) {
                cur = cur.children.get(s);
            } else return false;
            if (cur.isEnd) return true;
        }
        return false;
    }
}

class 字典树解法 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a, b) -> a.compareTo(b));
        var res = new ArrayList<String>();
        var root = new Trie1();

        for (String name : folder) {
            if (!root.isSub(name)) res.add(name);
            root.insert(name);
        }
        return res;
    }
}
