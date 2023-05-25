package 回溯;

import java.util.HashSet;
import java.util.Set;

/**用光所有的字符，能产生多少种不同的排列*/
public class 活字印刷 {
    int res = -1;
    String tiles;
    int n;
    boolean[] choosed;//总体上哪些位置的字符已经被选择了

    public int numTilePossibilities(String tiles) {
        this.tiles = tiles;
        n = tiles.length();
        choosed = new boolean[n];
        backtrack();
        return res;
    }

    private void backtrack() {
        res++;
        Set<Character> visited = new HashSet<>();//本层已经选过的字符不要重复选择
        for (int i = 0; i < n; i++) {
            if (choosed[i]) continue;
            char c = tiles.charAt(i);
            if (visited.contains(c)) continue;
            visited.add(c);
            choosed[i] = true;
            backtrack();
            choosed[i] = false;
        }
    }
}
