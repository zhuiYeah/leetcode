package DFS和BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class _bfs相似度为k的字符串 {
    //标记一个字符串以及它这一步需要去和s2匹配的位置pos ， 也即 pos之前的cur与s2是完全匹配的
    //如果cur[pos] == s2[pos] ,那么pos++ ，直到找到cur与s2不匹配的pos
    //对于这个pos，cur向后寻找，找到与s2[pos]相等的cur[j] ,交换cur[j]和cur[pos]
    //之后将新得到字符串 先检查是否重复 再放入队列
    static class Pair {
        String s;
        int pos;

        public Pair(String s1, int i) {
            s = s1;
            pos = i;
        }
    }

    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(s1, 0));
        int res = 0;
        if (s1.equals(s2)) return res;
        //set存放所有出现过的字符串避免重复
        Set<String> set = new HashSet<String>();
        set.add(s1);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            res++;
            for (int i = 0; i < sz; i++) {
                Pair pair = queue.poll();
                assert pair != null;
                String cur = pair.s;
                int pos = pair.pos;
                while (pos < n && cur.charAt(pos) == s2.charAt(pos)) {
                    pos++;
                }
                //现在当前字符串的第pos个位置和s2字符串的第pos的位置的值不同
                //那么接下来需要从cur的第pos+1个位置开始找，找到与s2[pos]相同的字符，然后对cur执行交换
                for (int j = pos + 1; j < n; j++) {
                    //本身就匹配的字符串就不要去换它了，这是自找麻烦
                    if (cur.charAt(j) == s2.charAt(j)) continue;
                    //找到了cur的j位置的字符能与pos位置的s2匹配了
                    if (s2.charAt(pos) == cur.charAt(j)) {
                        String next = swap(cur, pos, j);
                        if (next.equals(s2)) return res;
                        if (!set.contains(next)) {
                            set.add(next);
                            queue.offer(new Pair(next, pos + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return new String(arr);
    }
}




