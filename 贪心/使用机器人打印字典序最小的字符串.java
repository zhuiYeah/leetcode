package 贪心;

import java.util.ArrayDeque;

//314场周赛
//给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
//删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
//删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。


//请你返回纸上能写出的字典序最小的字符串。
//贪心 + 栈
public class 使用机器人打印字典序最小的字符串 {
    int[] fre = new int[26];
    char min = 0;

    public String robotWithString(String s) {
        for (int i = 0; i < s.length(); i++) {
            fre[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < fre.length; i++) {
            if (fre[i] != 0) {
                min = (char) (i + 'a');
                break;
            }
        }
        var res = new StringBuilder();
        var roboot = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == min) {
                res.append(s.charAt(i));
                fre[min - 'a']--;
                check();
                while (!roboot.isEmpty() && roboot.peek() <= min) {
                    res.append(roboot.pop());
                }
            } else {
                roboot.push(s.charAt(i));
                fre[s.charAt(i) - 'a']--;
            }
        }
        while (!roboot.isEmpty()) {
            res.append(roboot.pop());
        }
        return res.toString();

    }

    public void check() {
        if (fre[min - 'a'] != 0) return;
        for (int i = min - 'a'; i < 26; i++) {
            if (fre[i] != 0) {
                min = (char) (i + 'a');
                return;
            }
        }
    }
}
