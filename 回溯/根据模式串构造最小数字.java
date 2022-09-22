package 回溯;

import java.util.ArrayList;

public class 根据模式串构造最小数字 {
    boolean[] visited = new boolean[10]; //用于标记数字1～9是否被选择
    ArrayList<Integer> path = new ArrayList<Integer>(); //java中的list，类似go中的切片

    public String smallestNumber(String pattern) {
        backtracking(0,pattern);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            res.append(path.get(i).toString());
        }
        return res.toString();
    }

    public boolean backtracking(int curIndex, String pattern) {//curIndex用于表示模式串的当前下标，根据模式串的当前下标来选择下一个数字
        if (path.size() == pattern.length()+1) {
            return true;
        }
        if (path.size() == 0) {
            for (int i = 1; i <= 9; i++) {
                path.add(i);
                visited[i] = true;
                if (backtracking(curIndex, pattern)) {
                    return true;
                } else {
                    path.remove(path.size() - 1);
                    visited[i] = false;
                }
            }
            return false;
        }
        if (pattern.charAt(curIndex) == 'I') {
            for (int i = path.get(path.size() - 1) + 1; i <= 9; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    path.add(i);
                    if (backtracking(curIndex + 1, pattern)) {
                        return true;
                    } else {
                        visited[i] = false;
                        path.remove(path.size() - 1);
                    }
                }
            }
            return false;
        } else {
            for (int i = path.get(path.size() - 1) - 1; i >= 1; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    path.add(i);
                    if (backtracking(curIndex + 1, pattern)) {
                        return true;
                    } else {
                        visited[i] = false;
                        path.remove(path.size() - 1);
                    }
                }
            }
            return false;
        }
    }

}


